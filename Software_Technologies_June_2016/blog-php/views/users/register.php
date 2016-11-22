<?php $this->title = 'Register New User'; ?>

<h1><?= htmlspecialchars($this->title) ?></h1>

<form method="post">
    Username:
    <div><input type="text" name="username" required></div>
    Password:
    <div><input type="password" name="password" required></div>
    Confirm password:
    <div><input type="password" name="confirm_password" required></div>
    Full name:
    <div><input type="text" name="full_name"></div>
    <div><input type="submit" value="Register"></div>
</form>
