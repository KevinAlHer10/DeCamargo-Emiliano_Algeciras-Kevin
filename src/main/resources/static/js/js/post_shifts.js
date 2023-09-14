window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_shift');

    formulario.addEventListener('submit', function (event) {

        const formData = {
            patientName: document.querySelector('#patientName').value,
            dentistName: document.querySelector('#dentistName').value,
            date: document.querySelector('#date').value

        };
        const url = '/shifts';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Add shift </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error. Please, try again</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#patientName').value = "";
        document.querySelector('#dentistName').value = "";
         document.querySelector('#date').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/get_dentists.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});