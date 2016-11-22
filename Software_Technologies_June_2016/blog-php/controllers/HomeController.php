<?php

class HomeController extends BaseController
{
    function index() {
        $posts = $this->model->getLatestPosts(5);
        $this->postsSidebar = $posts;
        $this->posts = array_splice($posts, 0, 3);       
    }
	
	function view(int $id) {
        $post = $this->model->getPostById($id);
        if ($post){
            $this->post = $post;
        }
        else{
            $this->addErrorMessage('Error: This post does not exist');
            $this->redirect('');
        }
    }
}
