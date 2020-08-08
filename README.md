# Bozo
Implementation of a dice game called bozo.

<h2>How to play</h2>
<h4>You have to roll 5 dices randomly 3 times, in the second and third
time you can choose  at most 2 dices to keep the value</h4>
<h4>After the thid roll you will have to choose a place in the scoreboard
to fill.</h4>
<h4>The scoreboard has 10 positions and each of them has an specific feature: </h4>
<div align="center">
  <h1>ScoreBoard</h1>
  <p><b>(1)  |   (7)    |   (4)          <br>
	-----------------------------				<br>	
		 (2)  |   (8)    |   (5)          <br>
	-----------------------------				<br>		
		 (3)  |   (9)    |   (6)          <br>
	---------------------------					<br>		
		      |   (10)   |	   	   				<br>		
		      +----------+ 	       				<br></b></p>
</div>
<ul>
  <li>Positon 1 to 6 -> You will score according to the number of dices
  you have with the value of the position. Exemple: If you have 3 dices
  with value 1 and you choose the position 1, you will socore 3 points 
  in the position 1. </li>
  <li>Position 7(FullHouse - 15 points) -> You have 3 dices with equal values and other 2 dices with another equal value. Exemple: 2 2 2 5 5</li>
  <li>Position 8(Sequence - 20 points)  -> You have a sequence of values(1 to 5 or 2 to 6).</li>
  <li>Position 9(Quadra - 30 points)    -> You have 4 dices with the same value.</li>
  <li>Position 10(General - 40 points)  -> You have all the dices with the same value.</li>
</ul>

<h4>After fill all the 10 positions of the scoreboard it will shows to you thow many points you have scored.</h4>