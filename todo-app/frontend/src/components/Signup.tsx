import React from 'react';
import './Signup.css';

export const Signup: React.FC = () => {
  return (
    <div className='Signup_content'>
      <div className='Signup_box'>
        <div className='Signup_title'>
          <h1>ユーザー登録</h1>
        </div>
        <div className='Signup_item'>
          <div className='Signup_label'>名前</div>
          <input type='text' />
        </div>
        <div className='Signup_item'>
          <div className='Signup_label'>パスワード</div>
          <input type='password' />
        </div>
        <div className='Signup_buttonGroup'>
          <button className='Signup_button'>登録する</button>
        </div>
      </div>
    </div>
  );
};
