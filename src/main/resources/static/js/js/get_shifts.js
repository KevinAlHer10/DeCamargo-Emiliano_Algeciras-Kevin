window.addEventListener('load', function () {
    (function(){

      const url = '/shifts';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
         for(shift of data){
            var table = document.getElementById("shiftsTable");
            var shiftRow =table.insertRow();
            let tr_id = 'tr_' + turno.id;
           shiftRow.id = tr_id;

            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + shift.id + '\"' +
                                      ' type="button" onclick="deleteBy('+shift.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + shift.id + '\"' +
                                      ' type="button" onclick="findBy('+shift.id+')" class="btn btn-info btn_id">' +
                                      shift.id +
                                      '</button>';

            shiftRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_patientName\">' + shift.patientName.toUpperCase() + '</td>' +
                    '<td class=\"td_dentistName\">' + shift.dentistName.toUpperCase() + '</td>' +
                    '<td class=\"td_date\">' + shift.date + '</td>' +
                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/get_shifts.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })