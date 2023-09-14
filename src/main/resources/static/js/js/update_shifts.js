window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
        let shiftId = document.querySelector('#shift_id').value;

        const formData = {
            id: document.querySelector('#shift_id').value,
            dentistName: document.querySelector('#dentistName').value,
            patientName: document.querySelector('#patientName').value,
            date: document.querySelector('#date').value,

        };

        const url = '/shifts';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    function findBy(id) {
          const url = '/shifts'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let shift = data;
              document.querySelector('#shift_id').value = shift.id;
              document.querySelector('#dentistName').value = shift.dentistName;
              document.querySelector('#patientName').value = shift.patientName;
              document.querySelector('#date').value = shift.date;
              document.querySelector('#div_shift_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }