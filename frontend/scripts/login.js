// Simple demo accounts
const demoAccounts = {
    'student@library.edu': { password: 'student123', role: 'student', name: 'John Student' },
    'admin@library.edu': { password: 'admin123', role: 'admin', name: 'Admin User' }
};

document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    
    // Check if account exists and password matches
    if (demoAccounts[email] && demoAccounts[email].password === password) {
        const user = demoAccounts[email];
        
        // Store user info in localStorage
        localStorage.setItem('currentUser', JSON.stringify({ email, role: user.role, name: user.name }));
        
        // Redirect based on role
        if (user.role === 'admin') {
            window.location.href = 'admin-dashboard.html';
        } else {
            window.location.href = 'dashboard.html';
        }
    } else {
        alert('Invalid email or password');
    }
});
