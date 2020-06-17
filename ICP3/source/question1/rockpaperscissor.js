//Rock Paper Scissors JavaScript File
//implementing the random function
function computer_option() {
    const rdmNum = Math.random();
    if (rdmNum < 0.34) return "r";
    if (rdmNum < 0.67 && rdmNum > 0.34) return "p";
    else return "s";
}
//Converting r, p, s to rock, paper and scissors
function convertToWord(letter) {
    if (letter === "r") return "ROCK";
    if (letter === "s") return "SCISSORS";
    else return "PAPER";
}

//function used to decide win, lose, and draw

function win(userOption, computerOption) {
    document.querySelector(".results>p").innerHTML = " You have choosen: " + convertToWord(userOption) + ". system choice: " + convertToWord(computerOption) + ". Great!! YOU WIN.";

}
//function used to decide win, lose, and draw

function lose(userOption, computerOption) {
    document.querySelector(".results>p").innerHTML = " You have choosen: " + convertToWord(userOption) + ". system choice: " + convertToWord(computerOption) + ". Oops! YOU LOST.";
}
//function used to decide win, lose, and draw

function draw(userOption, computerOption) {
    document.querySelector(".results>p").innerHTML = " You have choosen: " + convertToWord(userOption) + ". system choice: " + convertToWord(computerOption) + ". Ohh!!! IT'S A DRAW.";
}


//Main function
function rule(userOption) {
    const computerOption = computer_option();
    if (userOption + computerOption === "rs") {
        win(userOption, computerOption);
    } else if (userOption + computerOption === "pr") {
        win(userOption, computerOption);
    } else if (userOption + computerOption === "sp") {
        win(userOption, computerOption);
    } else if (userOption + computerOption === "rp") {
        lose(userOption, computerOption);
    } else if (userOption + computerOption === "ps") {
        lose(userOption, computerOption);
    } else if (userOption + computerOption === "sr") {
        lose(userOption, computerOption);
    } else {
        draw(userOption, computerOption);
    }
}
//Retreiving the user input
function main() {
    document.getElementById("rock").addEventListener("click", function () {
        rule("r");
    });
    document.getElementById("paper").addEventListener("click", function () {
        rule("p");
    });
    document.getElementById("scissors").addEventListener("click", function () {
        rule("s");
    })
}

main();