import React from 'react';
import { useHistory } from 'react-router-dom';
import './Signup.css';

export const Signup: React.FC = () => {
  const history = useHistory();

  const signup: React.FormEventHandler<HTMLFormElement> = async (event) => {
    event.preventDefault();
    history.push('/');
  };

  return (
    <div className='Signup_content'>
      <div className='Signup_box'>
        <div className='Signup_title'>
          <h1>ユーザー登録</h1>
        </div>
        <form className='Signup_form' onSubmit={signup}>
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
        </form>
      </div>
    </div>
  );
};
