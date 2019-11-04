"use strict";

window.onload = () => {
    console.log("max() : ", max(2, 3));
    console.log("maxOfThree() : ", maxOfThree(1, 4, 3));
    console.log("isVowel() : ", isVowel('a'));
    console.log("sum() : ", sum(1, 2, 3, 4));
    console.log("multiply() : ", multiply(1, 2, 3, 4));
    console.log("reverse() : ", reverse('reverse this string'));
    console.log("findLongestWord() : ", findLongestWord("short", "longest", "middle"));
    console.log("filterLongWords() : ", filterLongWords(["one", "three", "five", "seven"], 4));
    console.log("sumWithReduce() : ", sumWithReduce(1, 2, 3, 4));
    console.log("multiplyWithReduce() : ", multiplyWithReduce(1, 2, 3, 4));
    console.log("findSecondBiggest() : ", findSecondBiggest(19, 9, 11, 0, 12));
    console.log("printFibo() : ", printFibo(10, 0, 1));

    document.getElementById("max").innerHTML = "<h2>max()</h2>" + "<h4>Function</h4>" + max + "<h4>Result</h4>" + max(2, 3);
    document.getElementById("maxOfThree").innerHTML = "<h2>maxOfThree()</h2>" + "<h4>Function</h4>" + maxOfThree + "<h4>Result</h4>" + maxOfThree(1, 4, 3);
    document.getElementById("isVowel").innerHTML = "<h2>isVowel()</h2>" + "<h4>Function</h4>" + isVowel + "<h4>Result</h4>" + isVowel('a');
    document.getElementById("sum").innerHTML = "<h2>sum()</h2>" + "<h4>Function</h4>" + sum + "<h4>Result</h4>" + sum(1, 2, 3, 4);
    document.getElementById("multiply").innerHTML = "<h2>multiply()</h2>" + "<h4>Function</h4>" + multiply + "<h4>Result</h4>" + multiply(1, 2, 3, 4);
    document.getElementById("reverse").innerHTML = "<h2>reverse()</h2>" + "<h4>Function</h4>" + reverse + "<h4>Result</h4>" + reverse('reverse this string');
    document.getElementById("findLongestWord").innerHTML = "<h2>findLongestWord()</h2>" + "<h4>Function</h4>" + findLongestWord + "<h4>Result</h4>" + findLongestWord("short", "longest", "middle");
    document.getElementById("filterLongWords").innerHTML = "<h2>filterLongWords()</h2>" + "<h4>Function</h4>" + filterLongWords + "<h4>Result</h4>" + filterLongWords(["one", "three", "five", "seven"], 4);
    document.getElementById("sumWithReduce").innerHTML = "<h2>sumWithReduce()</h2>" + "<h4>Function</h4>" + sumWithReduce + "<h4>Result</h4>" + sumWithReduce(1, 2, 3, 4);
    document.getElementById("multiplyWithReduce").innerHTML = "<h2>multiplyWithReduce()</h2>" + "<h4>Function</h4>" + multiplyWithReduce + "<h4>Result</h4>" + multiplyWithReduce(1, 2, 3, 4);
    document.getElementById("findSecondBiggest").innerHTML = "<h2>findSecondBiggest()</h2>" + "<h4>Function</h4>" + findSecondBiggest + "<h4>Result</h4>" + findSecondBiggest(19, 9, 11, 0, 12);
    document.getElementById("printFibo").innerHTML = "<h2>printFibo()</h2>" + "<h4>Function</h4>" + printFibo + "<h4>Result</h4>" + printFibo(10, 0, 1);

    showCurrentTime();
}

const max = (num1, num2) => {
    return num1 >= num2 ? num1 : num2;
}

const maxOfThree = (num1, num2, num3) => {
    if (num1 >= num2 && num1 >= num3) {
        return num1;
    } else if (num2 >= num1 && num2 >= num3) {
        return num2;
    } else {
        return num3;
    }
}

const isVowel = (ch) => {
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        return ch + " is vowel";
    else
        return ch + " is consonant";
}

const sum = (...elements) => {
    let summ = 0;
    for (let i = 0; i < elements.length; i++) {
        summ += elements[i];
    }

    return summ;
}

const multiply = (...elements) => {
    let multiply = 1;
    for (let i = 0; i < elements.length; i++) {
        multiply *= elements[i];
    }

    return multiply;
}

const reverse = (element) => {
    return element.split("").reverse().join("");
}

const findLongestWord = (...elements) => {
    return elements.reduce((a, b) => { return a.length > b.length ? a : b; });
}

const filterLongWords = (elements, i) => {
    let arr = [];
    elements.forEach(element => {
        if (element.length > i)
            arr.push(element);
    });
    return arr;
}

const sumWithReduce = (...elements) => {
    return elements.reduce((a, b) => a + b, 0);
}


const multiplyWithReduce = (...elements) => {
    return elements.reduce((a, b) => a * b, 1);
}

const findSecondBiggest = (...elements) => {
    if (elements.length < 2) {
        return "Invalid Input";
    }

    let first = 0,
        second = 0;
    for (let i = 0; i < elements.length; i++) {
        if (elements[i] > first) {
            second = first;
            first = elements[i];
        } else if (elements[i] > second && elements[i] != first)
            second = elements[i];
    }

    if (second == 0)
        return "There is no second largest element";
    else
        return second;
}

const printFibo = (n, a, b) => {
    let arr = [a, b];
    for (let i = 2; i < n + 1; i++) {
        arr.push(arr[i - 2] + arr[i - 1])
    }

    return arr;
}

const showCurrentTime = () => {
    let time = new Date();
    let year = time.getFullYear();
    let month = addPrefix(time.getMonth() + 1);
    let day = addPrefix(time.getDate());
    let hour = addPrefix(time.getHours());
    let minutes = addPrefix(time.getMinutes());
    let seconds = addPrefix(time.getSeconds());

    document.getElementById("time").innerHTML = "<h1>" + year + "/" + month + "/" + day + " " + hour + ":" + minutes + ":" + seconds + "</h1>";
    let t = setTimeout(() => {
        showCurrentTime()
    }, 1000);
}

const addPrefix = (val) => {
    if (val < 10) {
        val = "0" + val;
    }
    return val;
}