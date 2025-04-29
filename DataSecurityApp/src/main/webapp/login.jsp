<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
    /* General Styling */
* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

/* Body Styling */
body {
    background: #f5f5f5;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    color: #333;
}

/* Container Styling */
.container {
    background: #ffffff;
    width: 100%;
    max-width: 420px;
    padding: 40px;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
    text-align: center;
    transition: 0.3s;
}

.container:hover {
    box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
}

/* Heading */
h2 {
    font-size: 28px;
    color: #2c3e50;
    margin-bottom: 300px;
    margin-left:50px;
}

/* Form Labels */
label {
    display: block;
    text-align: left;
    font-weight: 600;
    margin: 10px 0 5px;
    color: #555;
}

/* Form Inputs */
input {
    width: 100%;
    padding: 12px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 14px;
    transition: 0.3s;
    outline: none;
}

input:focus {
    border-color: #3498db;
    box-shadow: 0 0 8px rgba(52, 152, 219, 0.3);
}

/* Button Styling */
button {
    width: 100%;
    padding: 12px;
    background: #3498db;  /* Blue color */
    color: #fff;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 16px;
    transition: 0.3s;
}

button:hover {
    background: #2980b9;  /* Darker blue */
    transform: translateY(-2px);
}

/* Link Style */
a {
    color: #3498db;
    text-decoration: none;
    font-size: 14px;
    display: inline-block;
    margin-top: 12px;
    transition: 0.3s;
}

a:hover {
    color: #1abc9c;  /* Teal color on hover */
}

/* Responsive Design */
@media (max-width: 600px) {
    .container {
        width: 90%;
        padding: 30px;
    }
}

    </style>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>