var employee = (function () {
    var name;
    var age;
    var salary;

    function setAge(newAge) {
        age = newAge;
    }

    function setSalary(newSalary) {
        salary = newSalary;
    }

    function setName(newName) {
        name = newName;
    }

    function getAge() {
        return age;
    }

    function getSalary() {
        return salary;
    }

    function getName() {
        return name;
    }

    function increaseSalary(percentage) {
        setSalary(getSalary() * percentage);
        return getSalary();
    }

    function incrementAge() {
        setAge(getAge() + 1);
        return getAge();
    }

    return {
        setAge: function (age) { setAge(age) },
        setSalary: function (salary) { setSalary(salary) },
        setName: function (name) { setName(name) },
        increaseSalary: function (percentage) { increaseSalary(percentage) },
        incrementAge: function () { incrementAge() }
    };
})();