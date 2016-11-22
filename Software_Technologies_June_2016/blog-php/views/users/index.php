<?php $this->title = "Users"; ?>

<h1><?= htmlspecialchars($this->title)?></h1>

<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Full name</th>
    </tr>

    <?php foreach ($this->users as $user) : ?>
    <tr>
        <td><?=$user['id']?></td>
        <td><?=$user['username']?></td>
        <td><?=$user['full_name']?></td>
    </tr>
    <?php endforeach; ?>
</table>

