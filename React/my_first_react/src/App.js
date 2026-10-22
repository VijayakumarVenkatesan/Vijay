import React, { useState } from 'react';
import Header from "./Header";
import "./App.css";
import Counter from "./Count";

function App() {
  const [count, setCount] = useState(0);
  const [target, setTarget] = useState("");

  const set_Count = () => {
    setCount(count + 1);
  };

  const handleTargetChange = (e) => {
    setTarget(e.target.value);
  };

  return (
    <div style={{ textAlign: "center" }}>
      <Header />
      
      <label htmlFor='targetInput'>Enter a target</label>
      <input 
        id='targetInput' 
        type='number' 
        placeholder='Enter a target number'
        value={target}
        onChange={handleTargetChange}
      />
      
      <Counter count={count} target={parseInt(target)} />
      
      <button className="CountButton" onClick={set_Count}>
        Count
      </button>
    </div>
  );
}

export default App;
