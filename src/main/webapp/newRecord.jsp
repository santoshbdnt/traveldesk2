<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>



<head>

    <script type="text/javascript" src="js/newrecord.js"></script>
    <link rel="stylesheet" href="css/newrecord.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="index.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <style>
        select:invalid {
            color: grey;
        }

        option {
            color: black;
        }
    </style>

    <div>
        <div class="main-contrainer">
            <div class="center background mt-2">

                <h1 class="head">Basic Information</h1>
            </div>
            <form action="createrecord" method="post">
                <div>
                    <div class="row">
                        <div class="col-xxl-6 col-xl-6 col-lg-6 col-md-6 col-sm-12 col-xs-12 float-end">
                            <label><strong>In Number</strong></label>
                            <span class="span-color">*</span>
                            <input type="text" name="inNumber" id="min" class="form-control size-font" size="50px" />
                        </div>
                        <div class="col-xxl-6 col-xl-6 col-lg-6 col-md-6 col-sm-12 col-xs-12 float-end">
                            <label for="max"><strong>Concur Id</strong></label>
                            <span class="span-color">*</span><input type="text" name="concurId" id="max" class="form-control" />
                        </div>
                    </div>

                    <div class="mt-3">
                        <div class="row">
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-endft">
                                <label><strong>Title</strong></label>
                                <span class="span-color">*</span>
                                <select required class="w form-select" name="title">
                                    <option value="" disabled selected hidden class="select w size">Select Title</option>
                                    <option value="Mr." class="w">Mr.</option>
                                    <option value="Ms." class="w">Ms.</option>
                                    <option value="Mrs." class="w">Mrs.</option>
                                </select>


                            </div>
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label for="max"><strong>First Name</strong></label>
                                <span class="span-color">*</span><input type="text" name="fname" id="max" class="form-control" />
                            </div>
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label><strong>Middle Name</strong></label>

                                <input type="text" name="mname" id="min" class="form-control size" />
                            </div>
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label for="max"><strong>Last Name</strong></label>
                                <span class="span-color">*</span><input type="text" name="lname" id="max" class="form-control" />
                            </div>
                        </div>
                    </div>
                    <div class="mt-3">
                        <div class="row">
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label><strong>Approving Manager</strong></label>
                                <span class="span-color">*</span>
                                <input type="text" name="manager" id="min" class="form-control" />
                            </div>
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label for="max"><strong>Project Name</strong></label>
                                <span class="span-color">*</span><input type="text" name="projectName" id="max" class="form-control" />
                            </div>




                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label><strong>WBS Code</strong></label>
                                <span class="span-color">*</span>
                                <input type="text" name="wbsCode" id="min" class="form-control" />
                            </div>
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label for="max"><strong>Bill Ability</strong></label>
                                <span class="span-color">*</span><input type="text" name="billable" id="max" class="form-control" />
                            </div>
                        </div>
                    </div>
                    <div class="mt-3">
                        <div class="row">
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label><strong>Booking / Cancellation Date</strong></label>
                                <span class="span-color">*</span>
                                <input type="date" name="bcDate" id="min" class="form-control" />
                            </div>
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label for="max"><strong>DOB</strong></label>
                                <span class="span-color">*</span><input type="date" name="dob" id="max" class="form-control" />
                            </div>

                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label><strong>Email Id</strong></label>
                                <span class="span-color">*</span>
                                <input type="email" name="emailId" id="min" class="form-control" />
                            </div>
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label for="max"><strong>Mobile No</strong></label>
                                <span class="span-color">*</span><input type="number" name="mobileNumber" id="max" class="form-control" />
                            </div>
                        </div>
                    </div>
                    <div class="mt-3">
                        <div class="row">
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label><strong>Designation</strong></label>
                                <span class="span-color">*</span>
                                <input type="text" name="designation" id="min" class="form-control" />
                            </div>
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label for="max"><strong>Gender</strong></label>
                                <span class="span-color">*</span>
                                <br>
                                <!--  <select name="gender" class="w">
                                    <option class="w">
                                        Select
                                    </option>
                                    <option class="w">Male</option>
                                    <option>Female</option>
                                </select>-->
                                <select name="gender" required class="w form-select">
                                    <option value="" disabled selected hidden class="select w">Choose Gender</option>
                                    <option class="w">Male</option>
                                    <option class="w">Female</option>
                                </select>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="center background mt-3">

                    <h1 class="head">Traveller Information</h1>
                </div>

                <div>
                    <div class="row">
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label><strong>From</strong></label>
                            <span class="span-color">*</span>
                            <input type="text" name="from" id="min" class="form-control" />
                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label for="max"><strong>TO</strong></label>
                            <span class="span-color">*</span><input type="text" name="to" id="max" class="form-control" />
                        </div>

                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label><strong>Onward</strong></label>
                            <span class="span-color">*</span>
                            <input type="date" name="onwardDate" id="min" class="form-control" />
                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label for="max"><strong>Return</strong></label>
                            <span class="span-color">*</span><input type="date" name="returnDate" id="max" class="form-control" />
                        </div>


                    </div>
                </div>


                <div class="row  mt-3">
                    <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                        <label id="servicerequired"> <strong>Service
                                Required:<span class="color"></span>
                            </strong></label>
                    </div>
                    <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                        <!-- <select id="ddlPassport" name="serviceRequired" onchange="ShowHideDiv()" class="form-select flight" style="width: 100%" required>
                            <option value="Train"> Select</option>
                            <option value="Train" id="train">Train</option>
                            <option value="Flight" id="flight">Flight</option>

                            <option value="Bus" id="bus">Bus</option>
                        </select>-->
                        <select id="ddlPassport" name="serviceRequired" onchange="ShowHideDiv()" class="form-select flight w" style="width: 100%" required>
                            <option value="" disabled selected hidden class="select w">Select </option>
                            <option class="w" value="Train" id="train">Train</option>
                            <option class="w" value="Flight" id="flight">Flight</option>
                            <option class="w" value="Bus" id="bus">Train</option>
                        </select>


                    </div>
                </div>

                <div class="mt-3">
                    <div class="row">

                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <div id="dvPassportairline" style="display: none">
                                <label><strong>Airline </strong></label>
                                <span class="span-color">*</span>
                                <input type="text" name="airline" class="form-control" />
                            </div>
                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <div id="dvPassportflightnumber" style="display: none">
                                <label for="max"><strong>Flight Number</strong></label>
                                <span class="span-color">*</span><input type="text" name="flightNumber" class="form-control" />
                            </div>
                        </div>




                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <div id="dvPassporttime" style="display: none">
                                <label for="max"><strong>Land Time</strong></label>
                                <span class="span-color">*</span><input type="time" name="flightTime" class="form-control" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mt-3">
                    <div class="row">

                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <div id="dvpassportcode" style="display: none">
                                <label><strong>Service Code </strong></label>
                                <span class="span-color">*</span>
                                <input type="text" name="serviceCode" class="form-control" />
                            </div>
                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <div id="dvpassportbus" style="display: none">
                                <label for="max"><strong>Bus Number</strong></label>
                                <span class="span-color">*</span><input type="text" name="busNumber" class="form-control" />
                            </div>
                        </div>


                    </div>
                </div>
                <div class="mt-3">
                    <div class="row">
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label><strong>Trip Number</strong></label>
                            <span class="span-color">*</span>
                            <input type="text" name="tripNumber" class="form-control" />
                        </div>





                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label for="max"><strong>PNR Number</strong></label>
                            <span class="span-color">*</span><input type="text" name="pnr" class="form-control" />
                        </div>


                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label><strong>Vender Name</strong></label>
                            <span class="span-color">*</span>
                            <input type="text" name="vendor" class="form-control" />
                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label for="max"><strong>Vender Id</strong></label>
                            <span class="span-color">*</span><input type="text" name="vendorId" class="form-control" />
                        </div>


                    </div>
                </div>
                <div class="mt-3">
                    <div class="row">
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label><strong>Seat Preference</strong></label>

                            <!--   <select name="pSeat" class="w">
                                <option class="w">
                                    Select Seat
                                </option>
                                <option value="Window" class="w">Window</option>
                                <option value="Aisle">Aisle</option>
                                <option value="Middle">Middle</option>
                            </select>-->
                            <select required class="w form-select" name="pSeat">
                                <option value="" disabled selected hidden class=" select w">
                                    Select Seat
                                </option>
                                <option value="Window" class="w">Window</option>
                                <option value="Aisle" class="w">Aisle</option>
                                <option value="Middle" class="w">Middle</option>
                            </select>

                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label for="max"><strong>Class Preference </strong></label>
                            <!--  <select name="pClass" class="w">
                                <option class="w">
                                    Select Class
                                </option>
                                <option value="Business" class="w">Business</option>
                                <option value="First" >First</option>
                                <option value="Second">Second</option>
                            </select>-->
                            <select name="pClass" required class="w form-select">
                                <option value="" disabled selected hidden class=" select w">
                                    Select Class
                                </option>
                                <option value="Business" class="w">Business</option>
                                <option value="First" class="w">First</option>
                                <option value="Second" class="w">Second</option>
                            </select>


                        </div>

                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label><strong>Preference Meal</strong></label>

                            <!--  <select name="pFood" class="w">
                                <option class="w">
                                    Select Meal
                                </option>
                                <option value="Veg" class="w">Veg</option>
                                <option value="Non-veg">Non-veg</option>

                            </select>-->

                            <select name="pFood" required class="w form-select">
                                <option value="" disabled selected hidden class=" select w">
                                    Select Meal
                                </option>
                                <option value="Veg" class="w">Veg</option>
                                <option value="Non-veg" class="w">Non-veg</option>

                            </select>

                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-endnd">
                            <label for="max"><strong>Preferred Car</strong></label>
                            <!--   <select name="carType" class="w">
                                <option class="w">
                                    Select Car
                                </option>
                                <option value="SUV" class="w">Suv</option>
                                <option value="Sedan">Sedan</option>
                                <option value="Hachback">Hachback</option>
                            </select>-->
                            <select name="carType" required class="w form-select">
                                <option value="" disabled selected hidden class=" select w">
                                    Select Car
                                </option>
                                <option value="SUV" class="w">Suv</option>
                                <option value="Sedan" class="w">Sedan</option>
                                <option value="Hachback"> class="w">Hachback</option>
                            </select>
                        </div>

                    </div>
                </div>
                <div class="row  mt-3">
                    <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                        <label id="servicerequired"> <strong>Hotel:<span class="color"></span></strong></label>


                        <!--<select id="ddlPassport7" name="hotel" onchange="ShowHideDiv1()" class="form-select flight" style="width: 100%">
                                <option>Select:</option>
                                <option value="Yes" id="flight">Yes</option>
                                <option value="no" id="train">No</option>

                            </select> -->
                        <select required id="ddlPassport7" name="hotel" onchange="ShowHideDiv1()" class="form-select flight w" style="width: 100%">
                            <option value="" disabled selected hidden class=" select w">Select:</option>
                            <option value="Yes" id="flight" class="w">Yes</option>
                            <option value="no" id="train" class="w">No</option>

                        </select>


                    </div>
                </div>

                <div id="dvPassport11" style="display: none">
                    <div class="row mt-3">
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 ">
                            <div>
                                <label id="Hotel"> <strong>Hotel Preferences
                                        :<span class="color"></span>
                                    </strong></label>


                                <input type="text" name="hpr" class="form-control" />
                            </div>
                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6">
                            <label id="Hotel"> <strong>Notes :<span class="color"></span></strong></label>

                            <input type="text" name="notes" class="form-control" />

                        </div>


                    </div>
                </div>



                <div class="mt-3">
                    <div class="row">
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label><strong>Cancellation</strong></label>

                            <input type="text" name="cancelation" class="form-control" />
                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label for="max"><strong>Fare</strong></label>
                            <span class="span-color">*</span>
                            <input type="text" name="fare" class="form-control" />
                        </div>



                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label><strong>CGST</strong></label>
                            <span class="span-color">*</span>

                            <input type="number" name="cgst" class="form-control" />
                        </div>
                        <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                            <label for="max"><strong>SGST</strong></label>
                            <span class="span-color">*</span>
                            <input type="number" name="sgst" class="form-control" />
                        </div>


                    </div>
                    <div class="mt-3">
                        <div class="row">
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label><strong>Total</strong></label>
                                <span class="span-color">*</span>

                                <input type="number" name="total" class="form-control" />
                            </div>
                            <div class="col-xxl-3 col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-6 float-end">
                                <label for="max"><strong>Comments</strong></label>
                                <input type="text" name="comments" class="form-control" />
                            </div>


                        </div>
                    </div>
                    <div class="center mt-4 ">
                        <button class="btn btn-primary button">Submit</button>
                    </div>








            </form>
        </div>
    </div>

    </div>





    <script src="index.js"></script>
</body>

</html>