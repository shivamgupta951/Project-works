function validateLogin() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('error-message');
  
    // Clear previous error messages
    errorMessage.style.display = 'none';
  
    // Check if username and password are valid
    if (username === '' || password === '') {
      errorMessage.textContent = 'Please fill in both fields.';
      errorMessage.style.display = 'block';
      return false;
    }
  
    // Simulate a successful login for this example
    if (username === 'admin' && password === 'admin123') {
      alert('Login Successful!');
      window.location.href = 'dashboard.html'; // Redirect to the dashboard page
      return true;
    } else {
      errorMessage.textContent = 'Invalid username or password.';
      errorMessage.style.display = 'block';
      return false;
    }
  }
  
  // Live input validation for username
  function checkInput() {
    const username = document.getElementById('username').value;
    const feedback = document.getElementById('username-feedback');
    
    if (username.length < 3) {
      feedback.textContent = "Username must be at least 3 characters.";
      feedback.style.display = "block";
    } else {
      feedback.style.display = "none";
    }
  }
  
  // Live input validation for password
  function checkPassword() {
    const password = document.getElementById('password').value;
    const feedback = document.getElementById('password-feedback');
    
    if (password.length < 6) {
      feedback.textContent = "Password must be at least 6 characters.";
      feedback.style.display = "block";
    } else {
      feedback.style.display = "none";
    }
  }
  
  // Toggle password visibility
  function togglePassword() {
    const passwordField = document.getElementById('password');
    const toggleBtn = document.querySelector('.toggle-password');
  
    if (passwordField.type === "password") {
      passwordField.type = "text";
      toggleBtn.textContent = "Hide";
    } else {
      passwordField.type = "password";
      toggleBtn.textContent = "Show";
    }
  }
  