// Search Button

let searchBtn = document.querySelector(".btn");

searchBtn.addEventListener("click", function () {

    alert("Search Clicked");

});


// Bar Chart

new Chart(document.getElementById("barChart"), {

    type: "bar",

    data: {

        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],

        datasets: [{

            label: "# of Votes",

            data: [12, 19, 3, 5, 2, 3],

            backgroundColor: [
                "rgba(255,99,132,0.3)",
                "rgba(54,162,235,0.3)",
                "rgba(255,206,86,0.3)",
                "rgba(75,192,192,0.3)",
                "rgba(153,102,255,0.3)",
                "rgba(255,159,64,0.3)"
            ],

            borderColor: [
                "red",
                "blue",
                "gold",
                "green",
                "purple",
                "orange"
            ],

            borderWidth: 1
        }]
    }

});



// Area Chart

new Chart(document.getElementById("areaChart"), {

    type: "line",

    data: {

        labels: ["January", "February", "March", "April", "May", "June"],

        datasets: [{

            label: "Students",

            data: [100, 200, 150, 300, 250, 400],

            fill: true,

            backgroundColor: "rgba(13,110,253,0.2)",

            borderColor: "#0d6efd",

            tension: 0.4
        }]
    }

});