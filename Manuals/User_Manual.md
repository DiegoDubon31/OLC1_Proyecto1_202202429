# **User Manual - Prisoner's Dilemma** #

The **Prisoner's Dilemma** is a paradox in **decision theory**, where two individuals acting in their own **self-interest** fail to achieve the optimal outcome. It presents a scenario in which two suspects have been **arrested** for a crime. They are **separated** and **unable to communicate**, and each must independently choose between **cooperating** with the other or **defecting**.

The highest collective reward occurs when both choose to cooperate. However, rational self-interest often leads them to defect, resulting in a worse outcome for both.

They receive the following offers:

1. If one cooperates and the other defects, the cooperator receives no punishment (is released), while the defector receives the maximum sentence.
2. If both cooperate, they both receive a moderate sentence.
3. If both defect, they both receive a minor sentence (but worse than if they had cooperated).

This program simulates the prisoner's dilemma. It allows you to only load a **.cmp** file, analyze its content, and simulate matches based on the defined strategies. The analysis process ensures that the file follows the correct structure by checking for lexical and syntactical errors. If the file contains any lexical, the program will generate a report to help identify and correct them. If there a syntax error the program will **fail**. Once the analysis is complete, the program executes the matches according to the specified rules.

## **File Format (.cmp)** ##
To analyze and simulate matches, the program requires a .cmp file. This file must follow a specific structure that defines strategies and matches.

### **Basic Structure** ###
A .cmp file consists of:

1. Strategy Definitions: Define how players behave during the game.
2. Match Configuration: Determines which strategies will compete, how many rounds will be played, and how the scoring system works.
3. Execution Instructions: Specifies which matches to run and the seed for the random state.

### **Example of a valid .cmp file** ###
```java 
strategy Graaskamp {
    initial: D
    rules: [
        if round_number <= 2 then D,
        if round_number == 3 && get_moves_count(opponent_history, D) == 2 then C,
        if round_number > 3 && get_last_n_moves(opponent_history, 2) == [D, D] then D,
        else last_move(opponent_history)
    ]
}

strategy Random {
    initial: C
    rules: [
        if random < 0.5 then C,
        else D
    ]
}

match GraaskampvsRandom {
    players strategies: [Graaskamp, Random]
    rounds: 100
    scoring: {
        mutual cooperation: 3, 
        mutual defection: 1, 
        betrayal reward: 5, 
        betrayal punishment: 0 
    }
}

main {
    run [GraaskampvsRandom] with {
        seed: 42
    }
}
```
### **General Rules** ###
* Strategy and Match names should be unique.
* Rules must follow the correct syntax.
* Matches must specify only two strategies.
* The main block is required to execute the simulation.
* It could be **n** strategies with **n** rules, also **n** matches, and in main block there can be **n** run statements.
* The IDs for this program either for a strategy or a match can be numbers, letters, Upper or Lower case and underscore, example of valid ID:
    * 123abc
    * _myStrat
    * MY_match

## **Game Functions and States** ##
This program has **4 functions** and **5 states** these can be used for the **rules of a strategy** in the **if** statement, **then** action or **else** statement. 

### **Functions** ##
#### **1. `get_move(history, n)`**
- **Return Type**: Action
- **Description**: Retrieves the action at position `n` in the given history. (0-based index)
- **Error**: If `n` is greater than or equal to the history size.
- **Example:**
  ```
  get_move(opponent_history, 0) == C
  ```

#### **2. `last_move(history)`**
- **Return Type**: Action
- **Description**: Retrieves the last action in the specified history.
- **Example:**
  ```
  last_move(opponent_history) == C
  last_move(self_history) == D
  ```

#### **3. `get_moves_count(history, action)`**
- **Return Type**: Integer
- **Description**: Counts how many times a specific action appears in the given history.
- **Example:**
  ```
  get_moves_count(opponent_history, C) == 3
  get_moves_count(self_history, D) == 2
  ```

#### **4. `get_last_n_moves(history, n)`**
- **Return Type**: List<Action>
- **Description**: Retrieves the last `n` actions from the specified history.
- **Restrictions:**
  - `n` must be greater than 0.
  - **Error**: If `n` is greater than the history size.
- **Example:**
  ```
  get_last_n_moves(opponent_history, 3) == [C, D, C]
  ```

> **Note:** All system functions and counters use **0-based indexing**, meaning:
> - `round_number` starts at `0`.
> - `get_move(history, n)` uses indices starting from `0`.
> - `round_number == 0` refers to the initial round where `initial` is used.

---

### **States**
The following system states provide essential information about the current game state. They can be used within **strategy rules** to make decisions.

#### **1. `round_number`**
- **Type**: Integer
- **Description**: Represents the current round number (starting from `0`).
- **Example Usage:**
  ```
  round_number == 1  // Checks if it is the second round
  ```

#### **2. `opponent_history`**
- **Type**: List<Action>
- **Description**: The full history of the opponent’s moves.

#### **3. `self_history`**
- **Type**: List<Action>
- **Description**: The full history of the player's own moves.

#### **4. `total_rounds`**
- **Type**: Integer
- **Description**: The total number of rounds in the match.
- **Example Usage:**
  ```
  round_number == total_rounds  // Checks if it is the last round
  ```

#### **5. `random`**
- **Type**: Float (Range: 0.0 - 1.0)
- **Description**: Generates a random number between 0 and 1.
- **Example Usage:**
  ```
  random < 0.1  // 10% probability condition
  ```
- **Note:** The random number generator **resets at the start of each match**. This project uses a **deterministic random generator** for consistency in simulations.

## **Running the program** ##
Here is the screen you will be seeing while running this project: 

![Initial Screen](https://github.com/DiegoDubon31/-2S2024-OLC1_Proyecto1_202202429/blob/0b7a8792695f041ed62e2b946dd701464d4a1a13/Captura%20de%20pantalla%202025-03-08%20103949.png)

You can open files, save files and start a new file. The files **MUST** be **".cmp"**. You find this option in the **File** item in the menu bar. **See the red square** 

![File Screen](https://github.com/DiegoDubon31/-2S2024-OLC1_Proyecto1_202202429/blob/8c04815d94be10d5c85ca0045fccf0882cc78555/Captura%20de%20pantalla%202025-03-08%20114645.png)

After you opened or created a new .cmp file you press the **Execute** item in the menu bar and it displays an **Analyze** option. When you press this option it will analyze the file and play the round by round match. In the console will be displayed the round by round, and the final scores. **See the red square**

![Execute Screen](https://github.com/DiegoDubon31/-2S2024-OLC1_Proyecto1_202202429/blob/7ccb3c7a9c95896c3473a50217c1fe15356105cb/Captura%20de%20pantalla%202025-03-08%20125157.png)

Finally you can see the error and token reports in the **Report** option in the menu item, you press the **view** option and will open automatically the html reports. **See the red square**

![Reports Screen](https://github.com/DiegoDubon31/-2S2024-OLC1_Proyecto1_202202429/blob/df8f7efb07ea33ba64678abf8429dac2fabf3b3c/Captura%20de%20pantalla%202025-03-08%20125917.png)

**Tokens Report**
![Tokens Screen](https://github.com/DiegoDubon31/-2S2024-OLC1_Proyecto1_202202429/blob/df8f7efb07ea33ba64678abf8429dac2fabf3b3c/Captura%20de%20pantalla%202025-03-08%20125854.png)

**Error Report**
![Errors Screen](https://github.com/DiegoDubon31/-2S2024-OLC1_Proyecto1_202202429/blob/df8f7efb07ea33ba64678abf8429dac2fabf3b3c/Captura%20de%20pantalla%202025-03-08%20125906.png)

## **Final Remarks** ##
This manual provided an overview of the **Prisoner's Dilemma Simulator**, explaining its **purpose**, **file format (.cmp)**, **functions and states**, and **how to use the program**. 

By following this guide, you should now be able to:
- **Create and load .cmp files** containing strategies and matches.
- **Analyze files** to check for lexical and syntactical correctness.
- **Run simulations** based on the defined strategies.
- **View reports** for tokens and errors in an easy-to-read HTML format.

If you encounter any **issues or have questions**, feel free to refer to the documentation or reach out for support.

**Thank you for using the Prisoner’s Dilemma Simulator!** 
