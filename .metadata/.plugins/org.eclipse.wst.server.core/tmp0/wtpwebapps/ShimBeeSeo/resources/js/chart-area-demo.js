// Set new default font family and font color to mimic Bootstrap's default styling
(Chart.defaults.global.defaultFontFamily = "Metropolis"),
'-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = "#858796";

function number_format(number, decimals, dec_point, thousands_sep) {
    // *     example: number_format(1234.56, 2, ',', ' ');
    // *     return: '1 234,56'
    number = (number + "").replace(",", "").replace(" ", "");
    var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = typeof thousands_sep === "undefined" ? "," : thousands_sep,
        dec = typeof dec_point === "undefined" ? "." : dec_point,
        s = "",
        toFixedFix = function(n, prec) {
            var k = Math.pow(10, prec);
            return "" + Math.round(n * k) / k;
        };
    // Fix for IE parseFloat(0.55).toFixed(0) = 0;
    s = (prec ? toFixedFix(n, prec) : "" + Math.round(n)).split(".");
    if (s[0].length > 3) {
        s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
    }
    if ((s[1] || "").length < prec) {
        s[1] = s[1] || "";
        s[1] += new Array(prec - s[1].length + 1).join("0");
    }
    return s.join(dec);
}

// Area Chart Example
		$.ajax({
			url : "joinPerMonth.do",
			type : "get",
			dataType : "json",
			success : function(result){
				/* var month = result.month;
				var number = result.number; */
				
				var monthArr = [];
				var numberArr = [];
				for(var i = 0; i < result.length; i++) {
					monthArr.push(result[i].month);
					numberArr.push(result[i].num);
				}
				console.log(result);
				console.log(monthArr);
				console.log(numberArr);
				var ctx = document.getElementById("joinPerMonth");
				
				var myLineChart = new Chart(ctx,{ 
				    type: "line",
				    data: {
				        labels:monthArr
				        ,
				        datasets: [{
				            label: "회원 수",
				            lineTension: 0.3,
				            backgroundColor: "rgba(187, 51, 255, 0.05)",
				            borderColor: "rgba(187, 51, 255, 1)",
				            pointRadius: 3,
				            pointBackgroundColor: "rgba(187, 51, 255, 1)",
				            pointBorderColor: "rgba(187, 51, 255, 1)",
				            pointHoverRadius: 3,
				            pointHoverBackgroundColor: "rgba(187, 51, 255, 1)",
				            pointHoverBorderColor: "rgba(187, 51, 255, 1)",
				            pointHitRadius: 10,
				            pointBorderWidth: 2,
				            data:numberArr
				       
				        }]
				    },
				    options: {
				        maintainAspectRatio: false,
				        layout: {
				            padding: {
				                left: 10,
				                right: 25,
				                top: 25,
				                bottom: 0
				            }
				        },
				        scales: {
				            xAxes: [{
				                time: {
				                    unit: "date"
				                },
				                gridLines: {
				                    display: false,
				                    drawBorder: false
				                },
				                ticks: {
				                    maxTicksLimit: 7
				                }
				            }],
				            yAxes: [{
				                ticks: {
				                    maxTicksLimit: 5,
				                    padding: 10,
				                    // Include a dollar sign in the ticks
				                    callback: function(value, index, values) {
				                        return  number_format(value);
				                    }
				                },
				                gridLines: {
				                    color: "rgb(234, 236, 244)",
				                    zeroLineColor: "rgb(234, 236, 244)",
				                    drawBorder: false,
				                    borderDash: [2],
				                    zeroLineBorderDash: [2]
				                }
				            }]
				        },
				        legend: {
				            display: false
				        },
				        tooltips: {
				            backgroundColor: "rgb(255,255,255)",
				            bodyFontColor: "#858796",
				            titleMarginBottom: 10,
				            titleFontColor: "#6e707e",
				            titleFontSize: 14,
				            borderColor: "#dddfeb",
				            borderWidth: 1,
				            xPadding: 15,
				            yPadding: 15,
				            displayColors: false,
				            intersect: false,
				            mode: "index",
				            caretPadding: 10,
				            callbacks: {
				                label: function(tooltipItem, chart) {
				                    var datasetLabel =
				                        chart.datasets[tooltipItem.datasetIndex].label || "";
				                    return datasetLabel + number_format(tooltipItem.yLabel);
				                }
				            }
				        }
				    }
				});

    			}, /* callback 함수 요청되고나서 실행하는 함수*/
    			error : function() {
    				alert("loadResult error");
    			}
    		});
/* 	
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
    type: "line",
    data: {
        labels: [
            "1월",
            "2월",
            "3월",
            "4월",
            "5월",
            "6월",
            "7월",
            "8월",
            "9월",
            "10월",
            "11월",
            "12월"
        ],
        datasets: [{
            label: "회원 수",
            lineTension: 0.3,
            backgroundColor: "rgba(0, 97, 242, 0.05)",
            borderColor: "rgba(0, 97, 242, 1)",
            pointRadius: 3,
            pointBackgroundColor: "rgba(0, 97, 242, 1)",
            pointBorderColor: "rgba(0, 97, 242, 1)",
            pointHoverRadius: 3,
            pointHoverBackgroundColor: "rgba(0, 97, 242, 1)",
            pointHoverBorderColor: "rgba(0, 97, 242, 1)",
            pointHitRadius: 10,
            pointBorderWidth: 2,
            data: [
                0,
                10000,
                5000,
                15000,
                10000,
                20000,
                15000,
                25000,
                20000,
                30000,
                25000,
                40000
            ]
        }]
    },
    options: {
        maintainAspectRatio: false,
        layout: {
            padding: {
                left: 10,
                right: 25,
                top: 25,
                bottom: 0
            }
        },
        scales: {
            xAxes: [{
                time: {
                    unit: "date"
                },
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                ticks: {
                    maxTicksLimit: 7
                }
            }],
            yAxes: [{
                ticks: {
                    maxTicksLimit: 5,
                    padding: 10,
                    // Include a dollar sign in the ticks
                    callback: function(value, index, values) {
                        return  number_format(value);
                    }
                },
                gridLines: {
                    color: "rgb(234, 236, 244)",
                    zeroLineColor: "rgb(234, 236, 244)",
                    drawBorder: false,
                    borderDash: [2],
                    zeroLineBorderDash: [2]
                }
            }]
        },
        legend: {
            display: false
        },
        tooltips: {
            backgroundColor: "rgb(255,255,255)",
            bodyFontColor: "#858796",
            titleMarginBottom: 10,
            titleFontColor: "#6e707e",
            titleFontSize: 14,
            borderColor: "#dddfeb",
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: false,
            intersect: false,
            mode: "index",
            caretPadding: 10,
            callbacks: {
                label: function(tooltipItem, chart) {
                    var datasetLabel =
                        chart.datasets[tooltipItem.datasetIndex].label || "";
                    return datasetLabel + number_format(tooltipItem.yLabel);
                }
            }
        }
    }
});
*/