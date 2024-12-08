// Display a dynamic welcome message based on the time of day
function displayWelcomeMessage() {
    const welcomeSection = document.querySelector('.welcome h2');
    const hours = new Date().getHours();
    let greeting;

    if (hours < 12) {
        greeting = "Good Morning!";
    } else if (hours < 18) {
        greeting = "Good Afternoon!";
    } else {
        greeting = "Good Evening!";
    }

    welcomeSection.textContent = `${greeting} Welcome to your Personalized Recipe Manager!`;
}

// Add click event to buttons in the trending recipes section
function setupRecipeButtons() {
    const buttons = document.querySelectorAll('.view-btn');
    buttons.forEach((button, index) => {
        button.addEventListener('click', () => {
            alert(`Recipe ${index + 1} details will be displayed here!`);
        });
    });
}

// Enable basic search functionality
function setupSearchFeature() {
    const searchInput = document.getElementById('name');
    const searchLabel = document.querySelector('.search-bar label');

    searchInput.addEventListener('input', () => {
        const query = searchInput.value.trim();
        searchLabel.textContent = query ? `Searching for: "${query}"` : 'Search Recipes';
    });
}

// Initialize all functionality on page load
document.addEventListener('DOMContentLoaded', () => {
    displayWelcomeMessage();
    setupRecipeButtons();
    setupSearchFeature();
});

// Select the toggle button and the body element
const themeToggleButton = document.getElementById("theme-toggle");
const body = document.body;

// Function to toggle dark mode
function toggleDarkMode() {
    // Toggle the 'dark-mode' class on the body
    body.classList.toggle("dark-mode");

    // Update the button text and icon based on the theme
    if (body.classList.contains("dark-mode")) {
        themeToggleButton.innerHTML = '<i class="fa fa-sun-o"></i> Light Mode';
        localStorage.setItem("theme", "dark");
    } else {
        themeToggleButton.innerHTML = '<i class="fa fa-moon-o"></i> Dark Mode';
        localStorage.setItem("theme", "light");
    }
}

// Event listener for the toggle button
themeToggleButton.addEventListener("click", toggleDarkMode);

// Check localStorage for saved theme preference
const savedTheme = localStorage.getItem("theme");
if (savedTheme === "dark") {
    body.classList.add("dark-mode");
    themeToggleButton.innerHTML = '<i class="fa fa-sun-o"></i> Light Mode';
} else {
    themeToggleButton.innerHTML = '<i class="fa fa-moon-o"></i> Dark Mode';
}

// Get the button
const scrollToTopBtn = document.getElementById('scrollToTopBtn');

// When the user scrolls down 100px from the top of the document, show the button
window.onscroll = function () {
    if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
        scrollToTopBtn.style.display = "block";
    } else {
        scrollToTopBtn.style.display = "none";
    }
};

// When the user clicks the button, scroll to the top of the document
scrollToTopBtn.addEventListener('click', function () {
    window.scrollTo({
        top: 0,
        behavior: 'smooth' // Smooth scroll to top
    });
});

// Select all elements with the class 'animate-on-scroll' or 'animate-on-scroll-zoom'
const elementsToAnimate = document.querySelectorAll('.animate-on-scroll, .animate-on-scroll-zoom');

// Create an Intersection Observer to trigger the animation when elements come into view
const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            // Add 'visible' class when the element comes into view
            entry.target.classList.add('visible');
        } else {
            // Remove the 'visible' class when the element is out of view
            entry.target.classList.remove('visible');
        }
    });
}, {
    threshold: 0.3 // 30% of the element must be in view to trigger the animation
});

// Observe each element that needs animation
elementsToAnimate.forEach(element => {
    observer.observe(element);
});