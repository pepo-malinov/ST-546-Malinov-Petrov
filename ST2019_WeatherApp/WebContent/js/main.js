// Working with Arrays

var nameList = ["Alexander","Ivan","Andrey"];

// Standard way to iterate through array
for(var i = 0; i < nameList.length; i++){
    console.log(nameList[i]);
}


var valuesList = [1,6,9,10];


var sum = 0;
for(var i = 0; i < valuesList.length; i++){
    sum = sum + valuesList[i];
}
console.log(sum);

function calculateTotal(arrayOfNumbers){
    var sum = 0;
    for(var i = 0; i < arrayOfNumbers.length; i++){
        sum = sum + arrayOfNumbers[i];
    } 
    return sum;
}
var total = calculateTotal(valuesList);

var secondValuesList = [1,3,7,200];
var secondTotal = calculateTotal(secondValuesList);

console.log("calculateTotal:",total);
console.log("secondTotal:",secondTotal);


// Working with Objects

var person = {
    firstName: "John",
    lastName: "Doe",
    email: "john@abv.bg",
    username: "johnjohn",
}

// console.log(person.firstName);
// console.log(person["firstName"])

for(var key in person){
    console.log(key, person[key])
}


// Array of Objects


var peopleList = [
    {
        firstName: "John",
        lastName: "Doe",
        personalData: {
            email: "john@abv.bg",
            address: "Plovdiv"
        }
    },
    {
        firstName: "Al",
        lastName: "Bundy",
        personalData: {
            email: "al@abv.bg",
            address: "Sofia"
        }
    }
]


for(var index = 0; index < peopleList.length; index++){

    var currentPerson = peopleList[index];

    for(var personKey in currentPerson){
        var currentField = currentPerson[personKey];

        if(personKey === "personalData"){

            for(var dataKey in currentField){
                console.log(currentField[dataKey])
            }
        }
    }
}

peopleList.forEach( element => {
    console.log(element);
});