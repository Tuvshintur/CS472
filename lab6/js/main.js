const showCurrentTime = () => {
    let time = new Date();

    document.getElementById("time").innerHTML = time;
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

const students = [
    { sid: "000-98-0001", name: "James" },
    { sid: "000-98-0002", name: "Anna" },
    { sid: "000-98-0003", name: "Jeffrey" }
];

(function () {
    showCurrentTime();

    students.forEach(student => {
        addStudentToList(student);
    });

    let button = document.getElementById("submitBtn");
    button.onclick = addNewStudent;
})();

function addStudentToList(student) {
    let newStudent = document.createElement("li");
    let newStudentContent = document.createTextNode(student.sid + " - " + student.name);
    newStudent.setAttribute('class', 'list-group-item');
    newStudent.appendChild(newStudentContent);
    document.getElementById("studentlist").appendChild(newStudent);
}

function addNewStudent() {
    let sid = document.getElementById("sid");
    let fname = document.getElementById("name");

    if (sid.value != '' && fname.value != '') {
        let student = {
            "sid": sid.value,
            "name": fname.value
        };
        addStudentToList(student);
    }
}