<?php $this->title = 'Login'; ?>

<h1><?= htmlspecialchars($this->title) ?></h1>

<form method="post">
    Username:
    <div><input type="text" name="username" required></div>
    Password:
    <div><input type="password" name="password" required></div>
    <div><input type="submit" value="Login"></div>
</form>
