<?php

class UsersController extends BaseController
{
    public function register()
    {
		if ($this->isPost){
            $username = $_POST['username'];
            $password = $_POST['password'];
            $confirm_password = $_POST['confirm_password'];
            $full_name = $_POST['full_name'];

            if (strlen($username) <= 1){
                $this->setValidationError("username", "Username too short.");
                return;
            }
            if (strlen($password) <= 1){
                $this->setValidationError("password", "Password too short.");
                return;
            }
            if ($password != $confirm_password){
                $this->setValidationError("confirm_password", "Passwords do not match.");
                return;
            }

            $userId = $this->model->register(
                $username, $password, $full_name);
            if ($userId){
                $_SESSION['username'] = $username;
                $_SESSION['user_id'] = $userId;
                $this->addInfoMessage("Registration successful.");
                $this->redirect('');
            }
            else{
                $this->addErrorMessage("Error: Registration failed.");
            }
        }
    }

    public function login()
    {
        if ($this->isPost){
            $username = $_POST['username'];
            $password = $_POST['password'];

            $userId = $this->model->login(
                $username, $password);
            if ($userId){
                $_SESSION['username'] = $username;
                $_SESSION['user_id'] = $userId;
                $this->addInfoMessage("Login successful.");
                $this->redirect('');
            }
            else{
                $this->addErrorMessage("Error: Login failed.");
            }
        }
    }

    public function logout()
    {
		session_destroy();
        $this->redirect('');
    }

    public function index()
    {
        $this->authorize();
        $this->users = $this->model->getAll();
    }
}
