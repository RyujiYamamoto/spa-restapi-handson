import React from 'react';
import './Login.css';

export const Login: React.FC = () => {
  return (
    <div className='Login_content'>
      <div className='Login_box'>
        <div className='Login_title'>
          <h1>ログイン</h1>
        </div>
        <div className='Login_item'>
          <div className='Login_label'>名前</div>
          <input type='text' />
        </div>
        <div className='Login_item'>
          <div className='Login_label'>パスワード</div>
          <input type='password' />
        </div>
        <div className='Login_buttonGroup'>
          <button className='Login_button'>ログインする</button>
        </div>
      </div>
    </div>
  );
};
