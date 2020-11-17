import React from 'react';
import { Link } from 'react-router-dom';
import { useUserContext } from '../contexts/UserContext';
import './NavigationHeader.css';

export const NavigationHeader: React.FC = () => {
  const userContext = useUserContext();

  const logout = async () => {
    window.location.href = '/';
  };

  return (
    <header className='PageHeader_header'>
      <h1 className='PageHeader_title'>Todoアプリ</h1>
      <nav>
        <ul className='PageHeader_nav'>
          {userContext.isLoggedIn ? (
            <React.Fragment>
              <li>{userContext.userName}さん</li>
              <li>
                <button type='button' onClick={logout}>
                  ログアウト
                </button>
              </li>
            </React.Fragment>
          ) : (
            <li>
              <Link to='/login'>ログイン</Link>
            </li>
          )}
        </ul>
      </nav>
    </header>
  );
};
