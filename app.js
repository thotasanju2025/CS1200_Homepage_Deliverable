// Simple in-browser "state"
const state = {
  currentUser: {
    name: "Guest User",
    favoriteGenre: "Pop",
    experienceLevel: "Beginner",
  },
  savedLyrics: JSON.parse(localStorage.getItem("rythmix_saved_lyrics") || "[]"),
};

// --- Helper to render views ---
const viewContainer = document.getElementById("view-container");
const menuButtons = document.querySelectorAll(".menu-btn");

function setActiveButton(view) {
  menuButtons.forEach((btn) => {
    if (btn.dataset.view === view) {
      btn.classList.add("active");
    } else {
      btn.classList.remove("active");
    }
  });
}

function renderView(view) {
  switch (view) {
    case "home":
      renderHome();
      break;
    case "generate":
      renderGenerate();
      break;
    case "saved":
      renderSaved();
      break;
    case "profile":
      renderProfile();
      break;
    case "settings":
      renderSettings();
      break;
    case "logout":
      renderLogout();
      break;
    default:
      renderHome();
  }

  setActiveButton(view);
}

// --- Individual "screens" ---

function renderHome() {
  viewContainer.innerHTML = `
    <h2>Welcome to Rythmix</h2>
    <p>
      Rythmix is a conceptual AI-powered lyric generator designed to help
      music artists brainstorm new song ideas.
    </p>
    <p>
      Use the navigation above to:
    </p>
    <ul>
      <li>Generate new lyric ideas</li>
      <li>View your saved lyrics</li>
      <li>Update your profile</li>
      <li>Adjust simple settings</li>
      <li>Logout when you're done</li>
    </ul>
  `;
}

function renderGenerate() {
  viewContainer.innerHTML = `
    <h2>Generate New Lyrics</h2>
    <p>
      Imagine this is where your AI model would generate lyrics.
      For now, you can type your own and "save" them.
    </p>

    <div class="form-group">
      <label for="prompt">Mood or prompt</label>
      <input type="text" id="prompt" placeholder="e.g., sad breakup, summer vibes" />
    </div>

    <div class="form-group">
      <label for="lyrics">Lyrics</label>
      <textarea id="lyrics" placeholder="Write or paste your lyrics here..."></textarea>
    </div>

    <button class="btn-primary" id="saveLyricsBtn">Save Lyrics</button>
  `;

  document.getElementById("saveLyricsBtn").addEventListener("click", () => {
    const promptEl = document.getElementById("prompt");
    const lyricsEl = document.getElementById("lyrics");

    const prompt = promptEl.value.trim();
    const lyrics = lyricsEl.value.trim();

    if (!lyrics) {
      alert("Please enter some lyrics before saving.");
      return;
    }

    const entry = {
      id: Date.now(),
      prompt: prompt || "(no prompt provided)",
      lyrics,
      createdAt: new Date().toLocaleString(),
    };

    state.savedLyrics.unshift(entry);
    localStorage.setItem(
      "rythmix_saved_lyrics",
      JSON.stringify(state.savedLyrics)
    );

    promptEl.value = "";
    lyricsEl.value = "";

    alert("Lyrics saved!");
  });
}

function renderSaved() {
  if (state.savedLyrics.length === 0) {
    viewContainer.innerHTML = `
      <h2>Saved Lyrics</h2>
      <p>You don't have any saved lyrics yet. Try generating some first!</p>
    `;
    return;
  }

  const itemsHtml = state.savedLyrics
    .map(
      (entry) => `
      <li>
        <span>${entry.createdAt} • Prompt: ${entry.prompt}</span>
        <pre>${entry.lyrics}</pre>
      </li>
    `
    )
    .join("");

  viewContainer.innerHTML = `
    <h2>Saved Lyrics</h2>
    <ul class="saved-list">
      ${itemsHtml}
    </ul>
  `;
}

function renderProfile() {
  const { name, favoriteGenre, experienceLevel } = state.currentUser;

  viewContainer.innerHTML = `
    <h2>Profile</h2>
    <p>Update your basic profile details.</p>

    <div class="form-group">
      <label for="profileName">Name</label>
      <input type="text" id="profileName" value="${name}" />
    </div>

    <div class="form-group">
      <label for="profileGenre">Favorite Genre</label>
      <input type="text" id="profileGenre" value="${favoriteGenre}" />
    </div>

    <div class="form-group">
      <label for="profileLevel">Experience Level</label>
      <input type="text" id="profileLevel" value="${experienceLevel}" />
    </div>

    <button class="btn-primary" id="saveProfileBtn">Save Profile</button>
  `;

  document.getElementById("saveProfileBtn").addEventListener("click", () => {
    state.currentUser.name =
      document.getElementById("profileName").value || "Guest User";
    state.currentUser.favoriteGenre =
      document.getElementById("profileGenre").value || "Pop";
    state.currentUser.experienceLevel =
      document.getElementById("profileLevel").value || "Beginner";

    alert("Profile saved (locally for this demo).");
  });
}

function renderSettings() {
  viewContainer.innerHTML = `
    <h2>Settings</h2>
    <p>
      In a full app, this is where you would configure AI model options,
      language, and other preferences.
    </p>
    <p>
      For this CS1200 deliverable, this screen demonstrates that the
      navigation can be extended with more features.
    </p>
  `;
}

function renderLogout() {
  viewContainer.innerHTML = `
    <h2>Logout</h2>
    <p>You have been "logged out" of the demo experience.</p>
    <p>
      In a real app, this would return you to a login screen.
      For now, you can click <strong>Home</strong> to start again.
    </p>
  `;
}

// --- Wire up navigation buttons ---
menuButtons.forEach((btn) => {
  btn.addEventListener("click", () => {
    const view = btn.dataset.view;
    renderView(view);
  });
});

// Initial view
renderView("home");
