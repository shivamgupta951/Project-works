document.getElementById("registrationForm").addEventListener("submit", function(event) {
event.preventDefault();  // Prevent form submission to validate fields
let valid = true;
// Clear all previous error messages
clearErrors();
// Validate Name
const name = document.getElementById("name").value.trim();
if (name === "") {
    displayError("nameError", "Name is required.");
    valid = false;
}
// Validate Email
const email = document.getElementById("email").value.trim();
const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
if (!emailRegex.test(email)) {
    displayError("emailError", "Please enter a valid email address.");
    valid = false;
}
// Validate Password
const password = document.getElementById("password").value.trim();
if (password.length < 6) {
    displayError("passwordError", "Password must be at least 6 characters.");
    valid = false;
}
// Validate Phone Number
const phone = document.getElementById("phone").value.trim();
const phoneRegex = /^\d{10}$/;
if (!phoneRegex.test(phone)) {
    displayError("phoneError", "Phone number must be 10 digits.");
    valid = false;
}
// Validate Date of Birth (Age must be at least 18)
const dob = document.getElementById("dob").value;
const birthDate = new Date(dob);
const age = new Date().getFullYear() - birthDate.getFullYear();
if (age < 18) {
    displayError("dobError", "You must be at least 18 years old.");
    valid = false;
}
// Validate Profession
const profession = document.getElementById("profession").value.trim();
if (profession === "") {
    displayError("professionError", "Profession is required.");
    valid = false;
}
// Validate State
const state = document.getElementById("state").value.trim();
if (state === "") {
    displayError("stateError", "Please select your state.");
    valid = false;
}
// If all validations passed, submit the form (this example just alerts)
if (valid) {
    alert("Form successfully submitted!");
    // Here you can submit the form to the server, e.g., using AJAX or form.submit().
}
});

// Helper function to display error message
function displayError(fieldId, message) {
    const field = document.getElementById(fieldId);
    field.textContent = message;
}

function clearErrors() {
    const errors = document.querySelectorAll('.error');
    errors.forEach(error => error.textContent = '');
}