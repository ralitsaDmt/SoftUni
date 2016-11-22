<?php $this->title = 'Edit post'; ?>

<h1><?=htmlspecialchars($this->title)?></h1>

<form method="post">
    
    <div>Title:</div>
    <input type="text" name="post_title"
            value="<?=htmlspecialchars($this->post['title'])?>">
    <div>Content:</div>
    <textarea rows="10" name="post_content"
    ><?=htmlspecialchars($this->post['content'])?></textarea>
    <div>Date (yyyy-MM-dd hh:mm:ss):</div>

    <input type="datetime" name="post_date"
           value="<?=htmlspecialchars($this->post['date'])?>">
    <div>Author ID:</div>
    <?php var_dump($this->post['user_id'])?>
    <input type="text" name="user_id"
           value="<?=htmlspecialchars($this->post['user_id'])?>">
    <div><input type="submit" value="Edit post">
        <a href="<?=APP_ROOT?>/posts">[Cancel]</a></div>
</form>