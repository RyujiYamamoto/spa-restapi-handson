import React from 'react';
import { TodoItem } from './TodoItem';
import './TodoList.css';

type Todo = {
  id: number;
  text: string;
  completed: boolean;
};

type Props = {
  todos: Todo[];
  toggleTodoCompletion: (id: number) => void;
};

export const TodoList: React.FC<Props> = ({ todos, toggleTodoCompletion }) => {
  return (
    <ul className='TodoList_list'>
      {todos.map((todo) => (
        <TodoItem key={todo.id} id={todo.id} text={todo.text} completed={todo.completed} toggleTodoCompletion={toggleTodoCompletion} />
      ))}
    </ul>
  );
};
