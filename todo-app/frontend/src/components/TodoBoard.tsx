import React from 'react';
import './TodoBoard.css';
import { TodoFilter } from './TodoFilter';
import { TodoForm } from './TodoForm';
import { TodoList } from './TodoList';

export const TodoBoard: React.FC = () => {
  return (
    <div className="TodoBoard_content">
      <TodoForm/>
      <TodoFilter/>
      <TodoList/>
    </div>
  );
};
