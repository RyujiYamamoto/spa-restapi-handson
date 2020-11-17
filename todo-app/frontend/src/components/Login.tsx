import React from 'react';
import { useHistory } from 'react-router-dom';
import './Login.css';

export const Login: React.FC = () => {
  const history = useHistory();

  const login: React.FormEventHandler<HTMLFormElement> = async (event) => {
    event.preventDefault();
    history.push('/board');
  };

  return (
    <div className='Login_content'>
      <div className='Login_box'>
        <div className='Login_title'>
          <h1>ログイン</h1>
        </div>
        <form className='Login_form' onSubmit={login}>
          <div className='Login_item'>
            <div className='Login_label'>名前</div>
            <input type='text' />
          </div>
          <div className='Login_item'>
            <div className='Login_label'>パスワード</div>
            <input type='password' />
          </div>
          <div className='Login_buttonGroup'>
            <button type='submit' className='Login_button'>
              ログインする
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};
