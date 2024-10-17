<jsp:include page="./pages/include/header.jsp"></jsp:include>
<jsp:include page="./pages/include/navbar.jsp"></jsp:include>
<div class="container-fluid page-body-wrapper">
	<!-- partial:partials/_sidebar.html -->
	<nav class="sidebar sidebar-offcanvas" id="sidebar">
		<ul class="nav">
			<li class="nav-item nav-profile"><a href="#" class="nav-link">
					<div class="nav-profile-image">
						<img src="assets/images/faces/face1.jpg" alt="profile" /> <span
							class="login-status online"></span>
						<!--change to offline or busy as needed-->
					</div>
					<div class="nav-profile-text d-flex flex-column">
						<span class="font-weight-bold mb-2">Amit Patil</span> <span
							class="text-secondary text-small">Project Manager</span>
					</div> <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
			</a></li>

			<li class="nav-item"><a class="nav-link"
				data-bs-toggle="collapse" href="#auth" aria-expanded="false"
				aria-controls="auth"> <span class="menu-title">Librarian
						Panel</span> <i class="menu-arrow "></i> <i class="fa fa-user-circle  "></i>
			</a>

				<div class="collapse" id="auth">
					<ul class="nav flex-column sub-menu">


						<li class="nav-item"><a class="nav-link"
							href="LibrarianAddForm.html">Add Librarian</a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/login.html">Delete Librarian</a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/register.html">Update Liibrarian</a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/error-404.html">Show Librarian</a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/error-500.html"> Show Perticular
								Librarian </a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/error-500.html"> Change Librarian status
						</a></li></li>
		</ul>
</div>
</li>

<li class="nav-item"><a class="nav-link" data-bs-toggle="collapse"
	href="#auth-1" aria-expanded="false" aria-controls="auth"> <span
		class="menu-title">Student Panel</span> <i class="menu-arrow "></i> <i
		class="fa fa-user-circle  "></i>
</a>

	<div class="collapse" id="auth-1">
		<ul class="nav flex-column sub-menu">
			<li class="nav-item"><a class="nav-link" href="Student.jsp">Add
					New Student</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/login.html">Update Student</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/register.html">Show All Student </a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/error-404.html">Show Perticular Student</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/error-500.html"> Return to Back </a></li>
		</ul>
	</div></li>
<li class="nav-item"><a class="nav-link" data-bs-toggle="collapse"
	href="#auth-2" aria-expanded="false" aria-controls="auth"> <span
		class="menu-title">Book Panel</span> <i class="menu-arrow "></i> <i
		class="fa fa-user-circle  "></i>
</a>

	<div class="collapse" id="auth-2">
		<ul class="nav flex-column sub-menu">
			<li class="nav-item"><a class="nav-link" href="Student.jsp">Add
					Book</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/login.html">Delete Book</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/register.html">Update Book </a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/error-404.html">Show Book by Name</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/error-500.html">Show All Books</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/error-500.html">Book available</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/error-500.html">Issue Book</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/error-500.html">Return Book</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/error-500.html">Show All Issued Book</a></li>
			<li class="nav-item"><a class="nav-link"
				href="pages/samples/error-500.html">Return Back page </a></li>
		</ul>
	</div></li>
<li class="nav-item"><a class="nav-link" data-bs-toggle="collapse"
	href="#auth-3" aria-expanded="false" aria-controls="auth"> <span
		class="menu-title">Return Main Page</span> <i
		class="mdi mdi-home menu-icon"></i>

</a></li>

<li class="nav-item"><a class="nav-link" href="Student.jsp"> <span
		class="menu-title">Logout</span> <i class="mdi mdi-home menu-icon"></i>

</a></li>


</ul>
</nav>

<div class="main-panel">
	<div class="content-wrapper">
		<div class="page-header">
			<h3 class="page-title">
				<span class="page-title-icon bg-gradient-primary text-white me-2">
					<i class="mdi mdi-home"></i>
				</span> Admin Dashboard
			</h3>
			<nav aria-label="breadcrumb">
				<ul class="breadcrumb">
					<li class="breadcrumb-item active" aria-current="page"><span></span>Overview
						<i
						class="mdi mdi-alert-circle-outline icon-sm text-primary align-middle"></i>
					</li>
				</ul>
			</nav>
		</div>

		<div class="row">
			<div class="col-md-4 stretch-card grid-margin">
				<div class="card bg-gradient-danger card-img-holder text-white">
					<div class="card-body">
						<img src="./assets/images/dashboard/circle.svg"
							class="card-img-absolute" alt="circle-image">
						<h4 class="font-weight-normal mb-3">
							Total Books <i class="fa fa-hand-o-left"></i>
						</h4>
						<h2 class="mb-5">15,000</h2>

					</div>
				</div>
			</div>

			<div class="col-md-4 stretch-card grid-margin">
				<div class="card bg-gradient-info card-img-holder text-white">
					<div class="card-body">
						<img src="./assets/images/dashboard/circle.svg"
							class="card-img-absolute" alt="circle-image">
						<h4 class="font-weight-normal mb-3">
							Total issued Books <i class="fa fa-hand-o-left"></i>
						</h4>
						<h2 class="mb-5">400</h2>

					</div>
				</div>
			</div>

			<div class="col-md-4 stretch-card grid-margin">
				<div class="card bg-gradient-success card-img-holder text-white">
					<div class="card-body">
						<img src="assets/images/dashboard/circle.svg"
							class="card-img-absolute" alt="circle-image">
						<h4 class="font-weight-normal mb-3">
							Total Available Books <i class="fa fa-hand-o-left"></i>
						</h4>
						<h2 class="mb-5">1100</h2>

					</div>
				</div>
			</div>
			<img class="img-fluid" src="images/adminDash.jpg" alt="Description">
		</div>
	</br>
		<div class="row">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Recent Tickets</h4>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Assignee</th>
										<th>Subject</th>
										<th>Status</th>
										<th>Last Update</th>
										<th>Tracking ID</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><img src="assets/images/faces/face1.jpg" class="me-2"
											alt="image"> David Grey</td>
										<td>Fund is not recieved</td>
										<td><label class="badge badge-gradient-success">DONE</label>
										</td>
										<td>Dec 5, 2017</td>
										<td>WD-12345</td>
									</tr>
									<tr>
										<td><img src="assets/images/faces/face2.jpg" class="me-2"
											alt="image"> Stella Johnson</td>
										<td>High loading time</td>
										<td><label class="badge badge-gradient-warning">PROGRESS</label>
										</td>
										<td>Dec 12, 2017</td>
										<td>WD-12346</td>
									</tr>
									<tr>
										<td><img src="assets/images/faces/face3.jpg" class="me-2"
											alt="image"> Marina Michel</td>
										<td>Website down for one week</td>
										<td><label class="badge badge-gradient-info">ON
												HOLD</label></td>
										<td>Dec 16, 2017</td>
										<td>WD-12347</td>
									</tr>
									<tr>
										<td><img src="assets/images/faces/face4.jpg" class="me-2"
											alt="image"> John Doe</td>
										<td>Loosing control on server</td>
										<td><label class="badge badge-gradient-danger">REJECTED</label>
										</td>
										<td>Dec 3, 2017</td>
										<td>WD-12348</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-5 grid-margin stretch-card">
				<div class="card">
					<div class="card-body p-0 d-flex">
						<div id="inline-datepicker" class="datepicker datepicker-custom">
							<div class="datepicker datepicker-inline">
								<div class="datepicker-days" style="">
									<table class="table-condensed">
										<thead>
											<tr>
												<th colspan="7" class="datepicker-title"
													style="display: none;"></th>
											</tr>
											<tr>
												<th class="prev">�</th>
												<th colspan="5" class="datepicker-switch">June 2024</th>
												<th class="next">�</th>
											</tr>
											<tr>
												<th class="dow">Su</th>
												<th class="dow">Mo</th>
												<th class="dow">Tu</th>
												<th class="dow">We</th>
												<th class="dow">Th</th>
												<th class="dow">Fr</th>
												<th class="dow">Sa</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="old day" data-date="1716681600000">26</td>
												<td class="old day" data-date="1716768000000">27</td>
												<td class="old day" data-date="1716854400000">28</td>
												<td class="old day" data-date="1716940800000">29</td>
												<td class="old day" data-date="1717027200000">30</td>
												<td class="old day" data-date="1717113600000">31</td>
												<td class="day" data-date="1717200000000">1</td>
											</tr>
											<tr>
												<td class="day" data-date="1717286400000">2</td>
												<td class="day" data-date="1717372800000">3</td>
												<td class="day" data-date="1717459200000">4</td>
												<td class="day" data-date="1717545600000">5</td>
												<td class="day" data-date="1717632000000">6</td>
												<td class="day" data-date="1717718400000">7</td>
												<td class="day" data-date="1717804800000">8</td>
											</tr>
											<tr>
												<td class="day" data-date="1717891200000">9</td>
												<td class="day" data-date="1717977600000">10</td>
												<td class="day" data-date="1718064000000">11</td>
												<td class="day" data-date="1718150400000">12</td>
												<td class="day" data-date="1718236800000">13</td>
												<td class="day" data-date="1718323200000">14</td>
												<td class="day" data-date="1718409600000">15</td>
											</tr>
											<tr>
												<td class="day" data-date="1718496000000">16</td>
												<td class="day" data-date="1718582400000">17</td>
												<td class="today day" data-date="1718668800000">18</td>
												<td class="day" data-date="1718755200000">19</td>
												<td class="day" data-date="1718841600000">20</td>
												<td class="day" data-date="1718928000000">21</td>
												<td class="day" data-date="1719014400000">22</td>
											</tr>
											<tr>
												<td class="day" data-date="1719100800000">23</td>
												<td class="day" data-date="1719187200000">24</td>
												<td class="day" data-date="1719273600000">25</td>
												<td class="day" data-date="1719360000000">26</td>
												<td class="day" data-date="1719446400000">27</td>
												<td class="day" data-date="1719532800000">28</td>
												<td class="day" data-date="1719619200000">29</td>
											</tr>
											<tr>
												<td class="day" data-date="1719705600000">30</td>
												<td class="new day" data-date="1719792000000">1</td>
												<td class="new day" data-date="1719878400000">2</td>
												<td class="new day" data-date="1719964800000">3</td>
												<td class="new day" data-date="1720051200000">4</td>
												<td class="new day" data-date="1720137600000">5</td>
												<td class="new day" data-date="1720224000000">6</td>
											</tr>
										</tbody>
										<tfoot>
											<tr>
												<th colspan="7" class="today" style="display: none;">Today</th>
											</tr>
											<tr>
												<th colspan="7" class="clear" style="display: none;">Clear</th>
											</tr>
										</tfoot>
									</table>
								</div>

								<div class="datepicker-months" style="display: none;">
									<table class="table-condensed">
										<thead>
											<tr>
												<th colspan="7" class="datepicker-title"
													style="display: none;"></th>
											</tr>
											<tr>
												<th class="prev">�</th>
												<th colspan="5" class="datepicker-switch">2024</th>
												<th class="next">�</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td colspan="7"><span class="month">Jan</span><span
													class="month">Feb</span><span class="month">Mar</span><span
													class="month">Apr</span><span class="month">May</span><span
													class="month focused">Jun</span><span class="month">Jul</span><span
													class="month">Aug</span><span class="month">Sep</span><span
													class="month">Oct</span><span class="month">Nov</span><span
													class="month">Dec</span></td>
											</tr>
										</tbody>
										<tfoot>
											<tr>
												<th colspan="7" class="today" style="display: none;">Today</th>
											</tr>
											<tr>
												<th colspan="7" class="clear" style="display: none;">Clear</th>
											</tr>
										</tfoot>
									</table>
								</div>
								<div class="datepicker-years" style="display: none;">

									<table class="table-condensed">
										<thead>
											<tr>
												<th colspan="7" class="datepicker-title"
													style="display: none;"></th>
											</tr>
											<tr>
												<th class="prev">�</th>
												<th colspan="5" class="datepicker-switch">2020-2029</th>
												<th class="next">�</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td colspan="7"><span class="year old">2019</span><span
													class="year">2020</span><span class="year">2021</span><span
													class="year">2022</span><span class="year">2023</span><span
													class="year focused">2024</span><span class="year">2025</span><span
													class="year">2026</span><span class="year">2027</span><span
													class="year">2028</span><span class="year">2029</span><span
													class="year new">2030</span></td>
											</tr>
										</tbody>
										<tfoot>
											<tr>
												<th colspan="7" class="today" style="display: none;">Today</th>
											</tr>
											<tr>
												<th colspan="7" class="clear" style="display: none;">Clear</th>
											</tr>
										</tfoot>
									</table>
								</div>

								<div class="datepicker-decades" style="display: none;">
									<table class="table-condensed">
										<thead>
											<tr>
												<th colspan="7" class="datepicker-title"
													style="display: none;"></th>
											</tr>
											<tr>
												<th class="prev">�</th>
												<th colspan="5" class="datepicker-switch">2000-2090</th>
												<th class="next">�</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td colspan="7"><span class="decade old">1990</span><span
													class="decade">2000</span><span class="decade">2010</span><span
													class="decade focused">2020</span><span class="decade">2030</span><span
													class="decade">2040</span><span class="decade">2050</span><span
													class="decade">2060</span><span class="decade">2070</span><span
													class="decade">2080</span><span class="decade">2090</span><span
													class="decade new">2100</span></td>
											</tr>
										</tbody>
										<tfoot>
											<tr>
												<th colspan="7" class="today" style="display: none;">Today</th>
											</tr>
											<tr>
												<th colspan="7" class="clear" style="display: none;">Clear</th>
											</tr>
										</tfoot>
									</table>
								</div>

								<div class="datepicker-centuries" style="display: none;">
									<table class="table-condensed">
										<thead>
											<tr>
												<th colspan="7" class="datepicker-title"
													style="display: none;"></th>
											</tr>
											<tr>
												<th class="prev">�</th>
												<th colspan="5" class="datepicker-switch">2000-2900</th>
												<th class="next">�</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td colspan="7"><span class="century old">1900</span><span
													class="century focused">2000</span><span class="century">2100</span><span
													class="century">2200</span><span class="century">2300</span><span
													class="century">2400</span><span class="century">2500</span><span
													class="century">2600</span><span class="century">2700</span><span
													class="century">2800</span><span class="century">2900</span><span
													class="century new">3000</span></td>
											</tr>
										</tbody>
										<tfoot>
											<tr>
												<th colspan="7" class="today" style="display: none;">Today</th>
											</tr>
											<tr>
												<th colspan="7" class="clear" style="display: none;">Clear</th>
											</tr>
										</tfoot>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-7 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Recent Updates</h4>
						<div class="d-flex">
							<div
								class="d-flex align-items-center me-4 text-muted font-weight-light">
								<i class="mdi mdi-account-outline icon-sm me-2"></i> <span>jack
									Menqu</span>
							</div>
							<div
								class="d-flex align-items-center text-muted font-weight-light">
								<i class="mdi mdi-clock icon-sm me-2"></i> <span>October
									3rd, 2018</span>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-6 pe-1">
								<img src="assets/images/dashboard/img_1.jpg"
									class="mb-2 mw-100 w-100 rounded" alt="image"> <img
									src="assets/images/dashboard/img_4.jpg"
									class="mw-100 w-100 rounded" alt="image">
							</div>
							<div class="col-6 ps-1">
								<img src="assets/images/dashboard/img_2.jpg"
									class="mb-2 mw-100 w-100 rounded" alt="image"> <img
									src="assets/images/dashboard/img_3.jpg"
									class="mw-100 w-100 rounded" alt="image">
							</div>
						</div>
						<div class="d-flex mt-5 align-items-top">
							<img src="assets/images/faces/face3.jpg"
								class="img-sm rounded-circle me-3" alt="image">
							<div class="mb-0 flex-grow">
								<h5 class="me-2 mb-2">School Website - Authentication
									Module.</h5>
								<p class="mb-0 font-weight-light">It is a long established
									fact that a reader will be distracted by the readable content
									of a page.</p>
							</div>
							<div class="ms-auto">
								<i class="mdi mdi-heart-outline text-muted"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-7 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Project Status</h4>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>Name</th>
										<th>Due Date</th>
										<th>Progress</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>Herman Beck</td>
										<td>May 15, 2015</td>
										<td>
											<div class="progress">
												<div class="progress-bar bg-gradient-success"
													role="progressbar" style="width: 25%" aria-valuenow="25"
													aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</td>
									</tr>
									<tr>
										<td>2</td>
										<td>Messsy Adam</td>
										<td>Jul 01, 2015</td>
										<td>
											<div class="progress">
												<div class="progress-bar bg-gradient-danger"
													role="progressbar" style="width: 75%" aria-valuenow="75"
													aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</td>
									</tr>
									<tr>
										<td>3</td>
										<td>John Richards</td>
										<td>Apr 12, 2015</td>
										<td>
											<div class="progress">
												<div class="progress-bar bg-gradient-warning"
													role="progressbar" style="width: 90%" aria-valuenow="90"
													aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</td>
									</tr>
									<tr>
										<td>4</td>
										<td>Peter Meggik</td>
										<td>May 15, 2015</td>
										<td>
											<div class="progress">
												<div class="progress-bar bg-gradient-primary"
													role="progressbar" style="width: 50%" aria-valuenow="50"
													aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</td>
									</tr>
									<tr>
										<td>5</td>
										<td>Edward</td>
										<td>May 03, 2015</td>
										<td>
											<div class="progress">
												<div class="progress-bar bg-gradient-danger"
													role="progressbar" style="width: 35%" aria-valuenow="35"
													aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</td>
									</tr>
									<tr>
										<td>5</td>
										<td>Ronald</td>
										<td>Jun 05, 2015</td>
										<td>
											<div class="progress">
												<div class="progress-bar bg-gradient-info"
													role="progressbar" style="width: 65%" aria-valuenow="65"
													aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-5 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title text-dark">Todo List</h4>
						<div class="add-items d-flex">
							<input type="text" class="form-control todo-list-input"
								placeholder="What do you need to do today?">
							<button
								class="add btn btn-gradient-primary font-weight-bold todo-list-add-btn"
								id="add-task">Add</button>
						</div>
						<div class="list-wrapper">
							<ul class="d-flex flex-column-reverse todo-list todo-list-custom">
								<li>
									<div class="form-check">
										<label class="form-check-label"> <input
											class="checkbox" type="checkbox"> Meeting with Alisa
											<i class="input-helper"></i></label>
									</div> <i class="remove mdi mdi-close-circle-outline"></i>
								</li>
								<li class="completed">
									<div class="form-check">
										<label class="form-check-label"> <input
											class="checkbox" type="checkbox" checked=""> Call
											John <i class="input-helper"></i></label>
									</div> <i class="remove mdi mdi-close-circle-outline"></i>
								</li>
								<li>
									<div class="form-check">
										<label class="form-check-label"> <input
											class="checkbox" type="checkbox"> Create invoice <i
											class="input-helper"></i></label>
									</div> <i class="remove mdi mdi-close-circle-outline"></i>
								</li>
								<li>
									<div class="form-check">
										<label class="form-check-label"> <input
											class="checkbox" type="checkbox"> Print Statements <i
											class="input-helper"></i></label>
									</div> <i class="remove mdi mdi-close-circle-outline"></i>
								</li>
								<li class="completed">
									<div class="form-check">
										<label class="form-check-label"> <input
											class="checkbox" type="checkbox" checked=""> Prepare
											for presentation <i class="input-helper"></i></label>
									</div> <i class="remove mdi mdi-close-circle-outline"></i>
								</li>
								<li>
									<div class="form-check">
										<label class="form-check-label"> <input
											class="checkbox" type="checkbox"> Pick up kids from
											school <i class="input-helper"></i></label>
									</div> <i class="remove mdi mdi-close-circle-outline"></i>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="./pages/include/footer.jsp"></jsp:include>
</div>