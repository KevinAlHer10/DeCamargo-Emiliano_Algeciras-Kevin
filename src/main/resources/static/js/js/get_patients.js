window.addEventListener('load', function () {
    (function(){

      const url = '/patients';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
         for(patient of data){
            var table = document.getElementById("patientTable");
            var patientRow =table.insertRow();
            let tr_id = 'tr_' + patient.id;
            patientRow.id = tr_id;

            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + patient.id + '\"' +
                                      ' type="button" onclick="deleteBy('+patient.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + patient.id + '\"' +
                                      ' type="button" onclick="findBy('+patient.id+')" class="btn btn-info btn_id">' +
                                      patient.id +
                                      '</button>';

            patientRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_identificationNumber\">' + patient.td_identificationNumber.toUpperCase() + '</td>' +
                    '<td class=\"td_name\">' + patient.name.toUpperCase() + '</td>' +
                    '<td class=\"td_lastname\">' + patient.lastname.toUpperCase() + '</td>' +
                    '<td class=\"td_date\">' + patient.date + '</td>' +
                    '<td class=\"td_address\">' + patient.address.toUpperCase() + '</td>' +
                    '<td class=\"td_email\">' + patient.email.toUpperCase() + '</td>' +
                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/get_patients.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })