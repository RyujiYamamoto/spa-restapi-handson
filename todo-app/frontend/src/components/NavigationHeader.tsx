import React from 'react';
import { Link } from 'react-router-dom';
import './NavigationHeader.css';

export const NavigationHeader: React.FC = () => {
  const logout = async () => {
    window.location.href = '/';
  };

  return (
    <header className='PageHeader_header'>
      <h1 className='PageHeader_title'>Todoアプリ</h1>
      <nav>
        <ul className='PageHeader_nav'>
          <li>
            <Link to='/login'>ログイン</Link>
          </li>
          <li>テストユーザさん</li>
          <li>
            <button type='button' onClick={logout}>
              ログアウト
            </button>
          </li>
        </ul>
      </nav>
    </header>
  );
};
