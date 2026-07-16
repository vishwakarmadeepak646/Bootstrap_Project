<%@page import="com.sunilos.p4.util.MessageSource"%>
<%@page import="com.sunilos.p4.bean.RoleBean"%>
<%@page import="com.sunilos.p4.ctl.LoginCtl"%>
<%@page import="com.sunilos.p4.bean.UserBean"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%
MessageSource ms = MessageSource.getInstance();
String locale = ms.getLanguage();
UserBean userBean = (UserBean) session.getAttribute("user");
boolean loggedIn = userBean != null;
boolean isAdmin = loggedIn && userBean.getRoleId() == RoleBean.ADMIN;
boolean isStudent = loggedIn && userBean.getRoleId() == RoleBean.STUDENT;
String displayName = loggedIn ? userBean.getFirstName() + " (" + session.getAttribute("role") + ")" : "Guest";
%>


<style>
@media ( max-width : 991px) {
	#mainNav {
		background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);
		padding: 10px;
		border-radius: 0 0 10px 10px;
	}
}
</style>
<nav class="navbar navbar-expand-lg py-0"
	style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%); min-height: 58px;">
	<div class="container-fluid px-4">

		<!-- ===== Brand ===== -->
		<a class="navbar-brand fw-bold d-flex align-items-center gap-2 py-2"
			href="<%=ORSView.WELCOME_CTL%>"> <img
			src="<%=ORSView.APP_CONTEXT%>/img/customLogo.jpg" alt="ORS"
			height="34" class="rounded" style="object-fit: contain;"> <span>
				<%=ms.get("login.ors")%>
		</span>
		</a>

		<!-- Mobile toggler -->
		<button class="navbar-toggler border-0" type="button"
			data-bs-toggle="collapse" data-bs-target="#mainNav"
			aria-controls="mainNav" aria-expanded="false">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="mainNav">

			<!-- ===== Left nav — grouped dropdowns (logged-in only) ===== -->
			<%
			if (loggedIn) {
			%>
			<ul class="navbar-nav me-auto gap-0">

				<!-- ---- Marksheet ---- -->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle px-3 py-3" href="#"
					data-bs-toggle="dropdown"> <i
						class="bi bi-file-earmark-text me-1"></i> <%=ms.get("marksheet.title")%>
				</a>
					<ul
						class="dropdown-menu dropdown-menu-dark shadow border-0 rounded-3"
						style="min-width: 200px; background: #1a2e4a;">
						<li>
							<h6 class="dropdown-header text-uppercase text-info small">
								<i class="bi bi-search me-1"></i>
								<%=ms.get("marksheet.query")%>
							</h6>
						</li>
						<li><a class="dropdown-item"
							href="<%=ORSView.GET_MARKSHEET_CTL%>"> <i
								class="bi bi-search me-2 text-info"></i> <%=ms.get("marksheet.getMark")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.MARKSHEET_MERIT_LIST_CTL%>"> <i
								class="bi bi-trophy me-2 text-warning"></i> <%=ms.get("marksheet.merit")%>
						</a></li>
						<%
						if (isAdmin) {
						%>
						<li>
							<hr class="dropdown-divider border-secondary">
						</li>
						<li>
							<h6 class="dropdown-header text-uppercase text-info small">
								<i class="bi bi-gear me-1"></i>
								<%=ms.get("marksheet.manage")%>
							</h6>
						</li>
						<li><a class="dropdown-item"
							href="<%=ORSView.MARKSHEET_CTL%>"> <i
								class="bi bi-plus-circle me-2 text-success"></i> <%=ms.get("marksheet.add")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.MARKSHEET_LIST_CTL%>"> <i
								class="bi bi-list-ul me-2 text-primary"></i><%=ms.get("marksheet.list.title")%>
						</a></li>

						<%
						}
						%>
					</ul></li>

				<!-- ---- Academics: Colleges / Courses / Subjects (Admin only) ---- -->
				<%
				if (isAdmin) {
				%>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle px-3 py-3" href="#"
					data-bs-toggle="dropdown"> <i class="bi bi-mortarboard me-1"></i>
						<%=ms.get("aca.title")%>
				</a>
					<ul
						class="dropdown-menu dropdown-menu-dark shadow border-0 rounded-3"
						style="min-width: 210px; background: #1a2e4a;">

						<!-- Colleges -->
						<li>
							<h6 class="dropdown-header text-uppercase text-info small">
								<i class="bi bi-bank2 me-1"></i>
								<%=ms.get("welcome.college")%>
							</h6>
						</li>
						<li><a class="dropdown-item" href="<%=ORSView.COLLEGE_CTL%>">
								<i class="bi bi-plus-circle me-2 text-success"></i> <%=ms.get("aca.addClg")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.COLLEGE_LIST_CTL%>"> <i
								class="bi bi-building me-2 text-primary"></i> <%=ms.get("aca.clgList")%>
						</a></li>

						<li><hr class="dropdown-divider border-secondary"></li>

						<!-- Courses -->
						<li>
							<h6 class="dropdown-header text-uppercase text-info small">
								<i class="bi bi-journal-bookmark me-1"></i>
								<%=ms.get("aca.courses")%>
							</h6>
						</li>
						<li><a class="dropdown-item" href="<%=ORSView.COURSE_CTL%>">
								<i class="bi bi-plus-circle me-2 text-success"></i> <%=ms.get("aca.addCourses")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.COURSE_LIST_CTL%>"> <i
								class="bi bi-list-ul me-2 text-primary"></i> <%=ms.get("aca.coursesList")%>
						</a></li>

						<li><hr class="dropdown-divider border-secondary"></li>

						<!-- Subjects -->
						<li>
							<h6 class="dropdown-header text-uppercase text-info small">
								<i class="bi bi-card-text me-1"></i>
								<%=ms.get("aca.sub")%>
							</h6>
						</li>
						<li><a class="dropdown-item" href="<%=ORSView.SUBJECT_CTL%>">
								<i class="bi bi-plus-circle me-2 text-success"></i> <%=ms.get("aca.addSub")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.SUBJECT_LIST_CTL%>"> <i
								class="bi bi-list-ul me-2 text-primary"></i> <%=ms.get("aca.subList")%>
						</a></li>
					</ul></li>

				<!-- ---- People: Students / Faculty / Users / Roles (Admin only) ---- -->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle px-3 py-3" href="#"
					data-bs-toggle="dropdown" aria-expanded="false"> <i
						class="bi bi-people me-1"></i> <%=ms.get("people.title")%>
				</a>
					<ul
						class="dropdown-menu dropdown-menu-dark shadow border-0 rounded-3"
						style="min-width: 210px; background: #1a2e4a;">

						<!-- Students -->
						<li>
							<h6 class="dropdown-header text-uppercase text-info small">
								<i class="bi bi-mortarboard me-1"></i>
								<%=ms.get("welcome.students")%>
							</h6>
						</li>
						<li><a class="dropdown-item" href="<%=ORSView.STUDENT_CTL%>">
								<i class="bi bi-person-plus me-2 text-success"></i><%=ms.get("people.addStudent")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.STUDENT_LIST_CTL%>"> <i
								class="bi bi-people me-2 text-primary"></i><%=ms.get("people.studentList")%>
						</a></li>

						<li><hr class="dropdown-divider border-secondary"></li>

						<!-- Faculty -->
						<li>
							<h6 class="dropdown-header text-uppercase text-info small">
								<i class="bi bi-person-badge me-1"></i>
								<%=ms.get("people.faculty")%>
							</h6>
						</li>
						<li><a class="dropdown-item" href="<%=ORSView.FACULTY_CTL%>">
								<i class="bi bi-plus-circle me-2 text-success"></i><%=ms.get("people.addFaculty")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.FACULTY_LIST_CTL%>"> <i
								class="bi bi-person-lines-fill me-2 text-primary"></i> <%=ms.get("people.facultyList")%>
						</a></li>

						<li><hr class="dropdown-divider border-secondary"></li>

						<!-- Users -->
						<li>
							<h6 class="dropdown-header text-uppercase text-info small">
								<i class="bi bi-person-gear me-1"></i>
								<%=ms.get("people.user")%>
							</h6>
						</li>
						<li><a class="dropdown-item" href="<%=ORSView.USER_CTL%>">
								<i class="bi bi-person-plus me-2 text-success"></i><%=ms.get("people.addUser")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.USER_LIST_CTL%>"> <i
								class="bi bi-person-lines-fill me-2 text-primary"></i> <%=ms.get("people.userList")%>
						</a></li>

						<li><hr class="dropdown-divider border-secondary"></li>

						<!-- Roles -->
						<li>
							<h6 class="dropdown-header text-uppercase text-info small">
								<i class="bi bi-shield-check me-1"></i>
								<%=ms.get("people.role")%>
							</h6>
						</li>
						<li><a class="dropdown-item" href="<%=ORSView.ROLE_CTL%>">
								<i class="bi bi-plus-circle me-2 text-success"></i> <%=ms.get("people.addRole")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.ROLE_LIST_CTL%>"> <i
								class="bi bi-shield-fill-check me-2 text-primary"></i> <%=ms.get("people.roleList")%>
						</a></li>

					</ul></li>

				<!-- ---- Reports (Admin only) ---- -->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle px-3 py-3" href="#"
					data-bs-toggle="dropdown" aria-expanded="false"> <i
						class="bi bi-file-earmark-bar-graph me-1"></i> <%=ms.get("report.title")%>
				</a>
					<ul
						class="dropdown-menu dropdown-menu-dark shadow border-0 rounded-3"
						style="min-width: 230px; background: #1a2e4a;">

						<!-- Academics -->
						<li>
							<h6 class="dropdown-header text-uppercase text-warning small">
								<i class="bi bi-mortarboard me-1"></i>
								<%=ms.get("aca.title")%>
							</h6>
						</li>
						<li><a class="dropdown-item"
							href="<%=ORSView.COLLEGE_REPORT_CTL%>" target="_blank"> <i
								class="c vbnmbi bi-file-earmark-pdf me-2 text-warning"></i><%=ms.get("aca.clgList")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.COURSE_REPORT_CTL%>" target="_blank"> <i
								class="bi bi-file-earmark-pdf me-2 text-warning"></i><%=ms.get("aca.coursesList")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.SUBJECT_REPORT_CTL%>" target="_blank"> <i
								class="bi bi-file-earmark-pdf me-2 text-warning"></i> <%=ms.get("aca.subList")%>
						</a></li>

						<li><hr class="dropdown-divider border-secondary"></li>

						<!-- People -->
						<li>
							<h6 class="dropdown-header text-uppercase text-warning small">
								<i class="bi bi-people me-1"></i><%=ms.get("people.title")%>
							</h6>
						</li>
						<li><a class="dropdown-item"
							href="<%=ORSView.STUDENT_REPORT_CTL%>" target="_blank"> <i
								class="bi bi-file-earmark-pdf me-2 text-warning"></i><%=ms.get("people.studentList")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.FACULTY_REPORT_CTL%>" target="_blank"> <i
								class="bi bi-file-earmark-pdf me-2 text-warning"></i> <%=ms.get("people.facultyList")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.USER_REPORT_CTL%>" target="_blank"> <i
								class="bi bi-file-earmark-pdf me-2 text-warning"></i> <%=ms.get("people.userList")%>
						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.ROLE_REPORT_CTL%>" target="_blank"> <i
								class="bi bi-file-earmark-pdf me-2 text-warning"></i> <%=ms.get("people.roleList")%>
						</a></li>

						<li><hr class="dropdown-divider border-secondary"></li>

						<!-- Results -->
						<li>
							<h6 class="dropdown-header text-uppercase text-warning small">
								<i class="bi bi-clipboard-data me-1"></i>
								<%=ms.get("report.result")%>
							</h6>
						</li>
						<li><a class="dropdown-item"
							href="<%=ORSView.MARKSHEET_REPORT_CTL%>" target="_blank"> <i
								class="bi bi-file-earmark-pdf me-2 text-warning"></i> <%=ms.get("marksheet.list.title")%>
						</a></li>

						<!-- Daily Module  -->
						<li>
							<h6 class="dropdown-header text-uppercase text-warning small">
								<i class="bi bi-journal-bookmark me-1"></i>
								<%=ms.get("daily.title")%>
							</h6>
						</li>
						<li><a class="dropdown-item"
							href="<%=ORSView.INSURANCE_REPORT_CTL%>" target="_blank"> <i
								class="bi bi-file-earmark-pdf me-2 text-warning"></i><%=ms.get("daily.insureanceReport")%>
						</a></li>

					</ul></li>

				<!------------ Daily Module ----------------->



				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle px-3 py-3" href="#"
					data-bs-toggle="dropdown" aria-expanded="false"> <i
						class="bi bi-journal-bookmark me-1"></i> <%=ms.get("daily.title")%>
				</a>
					<ul
						class="dropdown-menu dropdown-menu-dark shadow border-0 rounded-3"
						style="min-width: 230px; background: #1a2e4a;">

						<!-- Product -->
						<li>
							<h6 class="dropdown-header text-uppercase text-warning small">
								<i class="bi bi-cart-check me-1"></i>
								<%=ms.get("welcome.product")%>
							</h6>
						</li>
						<li><a class="dropdown-item" href="<%=ORSView.PRODUCT_CTL%>"
							target=""> <i class="bi bi-cart-plus me-2 text-warning"></i>
								<%=ms.get("daily.addProduct")%>

						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.PRODUCT_LIST_CTL%>" target=""> <i
								class="bi bi-cart4 me-2 text-warning"></i> <%=ms.get("daily.productList")%>
						</a></li>

						<li><hr class="dropdown-divider border-secondary"></li>

						<!-- Employee -->

						<li>
							<h6 class="dropdown-header text-uppercase text-warning small">
								<i class="bi bi-person-square me-1"></i>
								<%=ms.get("daily.emp")%>
							</h6>
						</li>
						<li><a class="dropdown-item" href="<%=ORSView.EMPLOYEE_CTL%>"
							target=""> <i class="bi bi-person-fill-add"></i> <%=ms.get("daily.addEmp")%>

						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.EMPLOYEE_LIST_CTL%>" target=""> <i
								class="bi bi-person-lines-fill me-2 text-warning"></i> <%=ms.get("daily.empList")%>
						</a></li>


						<!-- Interview -->
						<li><hr class="dropdown-divider border-secondary"></li>
						<li>
							<h6 class="dropdown-header text-uppercase text-warning small">
								<i class="bi bi-person-badge me-1"></i>
								<%=ms.get("daily.int")%>
							</h6>
						</li>
						<li><a class="dropdown-item"
							href="<%=ORSView.INTERVIEW_CTL%>" target=""> <i
								class="bi bi-person-badge-fill me-2 text-warning"></i> <%=ms.get("daily.addInt")%>

						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.INTERVIEW_LIST_CTL%>" target=""> <i
								class="bi bi-person-badge-fill me-2 text-warning"></i> <%=ms.get("daily.IntList")%>
						</a></li>


						<!-- Insurance -->
						<li><hr class="dropdown-divider border-secondary"></li>
						<li>
							<h6 class="dropdown-header text-uppercase text-warning small">
								<i class="bi bi-postcard-heart me-1"></i>
								<%=ms.get("daily.insurance")%>
							</h6>
						</li>
						<li><a class="dropdown-item"
							href="<%=ORSView.INSURANCE_CTL%>" target=""> <i
								class="bi bi-person-heart me-2 text-warning"></i> <%=ms.get("daily.addInsurance")%>

						</a></li>
						<li><a class="dropdown-item"
							href="<%=ORSView.INSURANCE_LIST_CTL%>" target=""> <i
								class="bi bi-person-heart me-2 text-warning"></i> <%=ms.get("daily.insuranceList")%>
						</a></li>

					</ul></li>



				<%
				}
				%>
				<%-- end isAdmin --%>

			</ul>
			<%
			} else {
			%>
			<ul class="navbar-nav me-auto"></ul>
			<%
			}
			%>

			<!-- ===== Right side ===== -->
			<ul class="navbar-nav align-items-lg-center gap-1 ms-2">

				<!-- Language -->
				<li class="nav-item">
					<form class="d-flex align-items-center m-0">
						<select class="form-select form-select-sm border-0 py-1"
							name="lang" id="lang" onchange="this.form.submit()"
							style="width: 120px; background: rgba(255, 255, 255, 0.12); color: #fff; font-size: 0.82rem; cursor: pointer;">
							<option value="en" <%=("en".equals(locale)) ? "selected" : ""%>
								style="background: #0d2137; color: #fff;">&#127758;
								English</option>
							<option value="hi" <%=("hi".equals(locale)) ? "selected" : ""%>
								style="background: #0d2137; color: #fff;">&#127470;&#127475;
								Hindi</option>
						</select>
					</form>
				</li>

				<!-- Home -->
				<li class="nav-item"><a class="nav-link px-2"
					href="<%=ORSView.WELCOME_CTL%>"> <i class="bi bi-house-fill"></i>
						<span class="d-lg-none ms-1">Home</span>
				</a></li>


				<%-- <li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle d-flex align-items-center gap-1 px-2"
					href="#" data-bs-toggle="dropdown" aria-expanded="false"> <img
						src="<%=ORSView.UPLOAD_PHOTO_CTL%>?id=<%=userBean.getId()%>"
						alt="User Photo" class="rounded-circle border" width="28"
						height="28" style="object-fit: cover; flex-shrink: 0;"> <span
						class="d-none d-lg-inline small"><%=userBean.getFirstName()%></span>
				</a> --%>

				<!-- My Account dropdown (logged-in) -->
				<%
				if (loggedIn) {
				%>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle d-flex align-items-center gap-1 px-2"
					href="#" data-bs-toggle="dropdown" aria-expanded="false"> <img
						src="<%=ORSView.UPLOAD_PHOTO_CTL%>?id=<%=userBean.getId()%>"
						alt="User Photo" class="rounded-circle border" width="28"
						height="28" style="object-fit: cover; flex-shrink: 0;"> <span
						class="d-none d-lg-inline small"><%=userBean.getFirstName()%></span>
				</a>
					<ul
						class="dropdown-menu dropdown-menu-dark dropdown-menu-end shadow border-0 rounded-3"
						style="min-width: 210px; background: #1a2e4a;">
						<li>
							<div class="px-3 py-2 border-bottom border-secondary">
								<div class="text-white fw-semibold small">
									<%=displayName%>
								</div>
								<div class="text-white-50" style="font-size: 0.75rem;">
									<%=userBean.getLogin()%>
								</div>
							</div>
						</li>
						<%-- <li><a class="dropdown-item mt-1"
							href="<%=ORSView.MY_PROFILE_CTL%>"> <img
								src="<%=ORSView.UPLOAD_PHOTO_CTL%>?id=<%=userBean.getId()%>"	<!-- <i class="bi bi-person-circle me-2 text-info"></i> -->
								alt="User Photo" class="rounded-circle border" width="20"
								height="20" align="top"
								style="object-fit: cover; flex-shrink: 0;">


								<%=ms.get("login.profile")%>
						</a></li> --%>

						<li><a class="dropdown-item d-flex align-items-center"
							href="<%=ORSView.MY_PROFILE_CTL%>"> <img
								src="<%=ORSView.UPLOAD_PHOTO_CTL%>?id=<%=userBean.getId()%>"
								class="rounded-circle border" width="22" height="22"
								style="object-fit: cover;"> <span class="ms-2"><%=ms.get("login.profile")%></span>

						</a></li>

						<li><a class="dropdown-item"
							href="<%=ORSView.CHANGE_PASSWORD_CTL%>"> <i
								class="bi bi-key me-2 text-warning"></i> <%=ms.get("login.changePss")%>
						</a></li>
						<li><a class="dropdown-item" target="blank"
							href="<%=ORSView.JAVA_DOC_VIEW%>"> <i
								class="bi bi-book me-2 text-success"></i> <%=ms.get("login.javadoc")%>
						</a></li>
						<li>
							<hr class="dropdown-divider border-secondary">
						</li>
						<li><a class="dropdown-item text-danger"
							href="<%=ORSView.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOG_OUT%>">
								<i class="bi bi-box-arrow-right me-2"></i> <%=ms.get("login.logout")%>
						</a></li>
					</ul></li>

				<%
				} else {
				%>
				<!-- Login button (guest) -->
				<li class="nav-item"><a
					class="btn btn-sm btn-outline-light ms-1 px-3"
					href="<%=ORSView.LOGIN_CTL%>"> <i
						class="bi bi-box-arrow-in-right me-1"></i> <%=ms.get("login.signin")%>
				</a></li>
				<%
				}
				%>

			</ul>
		</div>
	</div>
</nav>