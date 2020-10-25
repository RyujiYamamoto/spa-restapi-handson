import React from 'react';
import './TodoForm.css';
import { useInput } from '../hooks/useInput';

export const TodoForm: React.FC = () => {
  const [text, textAttributes, setText] = useInput('');

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    //TODO:登録した際の処理を書く
  };

  return (
    <div className='TodoForm_content'>
      <form onSubmit={handleSubmit} className='TodoForm_form'>
        <div className='TodoForm_input'>
          <input type='text' {...textAttributes} placeholder='タスクを入力してください' />
        </div>
        <div className='TodoForm_button'>
          <button type='submit'>追加</button>
        </div>
      </form>
    </div>
  );
};
