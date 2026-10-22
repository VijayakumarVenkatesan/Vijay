import React from "react";
function Counter(props){
    
    const message=props.count===props.target?<h3>Congrats, you have reached {props.target}🙌<br/>Reward unlocked👍</h3>:props.count<props.target?<h3>You have {props.target - props.count} more steps to reach {props.target}</h3>:<h3>Already reached {props.target}</h3>;
    return(
    <>
        <h1>Count: {props.count}</h1>
        {message}
    </>
        
    )
}
export default Counter;