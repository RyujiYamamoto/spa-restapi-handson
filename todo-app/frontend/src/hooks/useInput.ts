import { useState } from "react";

/**
 * input要素のステートフックとステート更新をラッピングした独自フック。
 * 使用例は以下の通り。
 *
 * const Xxx: React.FC = () => {
 *  // 入力値のステートと、入力要素用の属性を取得する
 *  const [text, textAttributes] = useInput('');
 *  return (
 *    // スプレッド構文で展開して属性を一括設定する
 *    <input type='text' {...textAttributes}/>
 *  );
 *
 * @param initialState 初期値
 * @return [input要素のステート, input要素の属性, ステート更新の関数]
 */
export const useInput = (initialState: string = '') : [string, React.InputHTMLAttributes<HTMLInputElement>, React.Dispatch<React.SetStateAction<string>>] => {
  const [value, setValue] = useState<string>(initialState);

  const onChange = (event: React.FormEvent<HTMLInputElement>) => {
    setValue(event.currentTarget.value);
  };

  return [
    value,
    {
      value,
      onChange
    },
    setValue
  ];
};
