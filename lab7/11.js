var employee = (function () {
    var name;
    var age;
    var salary;
    var address;

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

    function getAddress() {
        return address;
    }

    function setAddress(newAddress) {
        address=newAddress;
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
        incrementAge: incrementAge,
        address:address,
        setAddress: function(address) {setAddress(address)},
        getAddress: getAddress
    };
})();