function solve() {

    const kinveyAppId = "kid_BJXTsSi-e";
    const serviceUrl = "https://baas.kinvey.com/appdata/" + kinveyAppId;
    const kinveyUsername = "guest";
    const kinveyPassword = "guest";
    const base64auth = btoa(kinveyUsername + ":" + kinveyPassword);
    const authHeaders = { "Authorization": "Basic " + base64auth };

    $('#btnAdd').click(addStudent);
    $('#loadStudents').click(loadStudents);

    function addStudent() {

        let ID = Number($('#id').val());
        let FirstName = $('#firstName').val();
        let LastName = $('#lastName').val();
        let FacultyNumber = $('#facultyNumber').val();
        let Grade = Number($('#grade').val());

        let student = {ID, FirstName, LastName, FacultyNumber,Grade};

        clearFields();

        $.ajax({
            url: serviceUrl + "/students",
            method: "POST",
            contentType: "application/json",
            headers: authHeaders,
            data: JSON.stringify(student),
            success: loadStudents,
            error: displayError
        });
    }

    function clearFields() {
        $('#id').val('');
        $('#firstName').val('');
        $('#lastName').val('');
        $('#facultyNumber').val('');
        $('#grade').val('');
    }

    function loadStudents() {
        $.ajax({
            url: serviceUrl + "/students",
            method: "GET",
            headers: authHeaders,
            success: displayStudents,
            error: displayError
        });
    }

    function displayStudents(data) {
        data = data.sort((s1, s2) => s1.ID - s2.ID);

        for (let student of data){
            let id = student.ID;
            let firstName= student.FirstName;
            let lastName = student.LastName;
            let facNumber = student.FacultyNumber;
            let grade = student.Grade;

            let tableRow = $('<tr>')
                .append($('<td>').text(id))
                .append($('<td>').text(firstName))
                .append($('<td>').text(lastName))
                .append($('<td>').text(facNumber))
                .append($('<td>').text(grade));

            $('#results')
                .append(tableHeaders)
                .append(tableRow);
        }
    }

    function displayError(err) {
        console.log(err.statusText);
    }

}