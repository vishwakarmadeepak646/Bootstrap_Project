
<%@page import="com.sunilos.p4.util.MessageSource"%>
<%@page import="com.sunilos.p4.bean.InsuranceBean"%>
<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%
int pageNo = ServletUtility.getPageNo(request);
int pageSize = ServletUtility.getPageSize(request);
int index = ((pageNo - 1) * pageSize) + 1;
List list = ServletUtility.getList(request);
Iterator<InsuranceBean> it = list.iterator();

String _err = ServletUtility.getErrorMessage(request);
String _suc = ServletUtility.getSuccessMessage(request);

MessageSource ms = MessageSource.getInstance();
String locale = ms.getLanguage();
%>

<div class="container-fluid px-4 py-4" style="max-width: 900px;">
	<div class="card border-0 shadow-sm rounded-4 overflow-hidden">

		<div
			class="card-header text-white border-0 py-3 px-4 d-flex justify-content-between align-items-center"
			style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);">
			<h5 class="mb-0 fw-bold">
				<i class="bi bi-cart me-2"></i><%=ms.get("daily.insuranceList")%>
			</h5>
			<div class="d-flex gap-2">
				<a href="<%=ORSView.INSURANCE_REPORT_CTL%>" target="_blank"
					class="btn btn-sm btn-warning fw-semibold"> <i
					class="bi bi-file-earmark-pdf me-1"></i> Print PDF
				</a> <a href="<%=ORSView.INSURANCE_REPORT_CTL%>?type=doc"
					target="_blank" class="btn btn-sm btn-info fw-semibold"> <i
					class="bi bi-file-earmark-word me-1"></i> Print DOC
				</a> <a href="<%=ORSView.INSURANCE_CTL%>"
					class="btn btn-sm btn-light text-primary fw-semibold"> <i
					class="bi bi-plus-circle me-1"></i> <%=ms.get("daily.addInsurance")%>
				</a>
			</div>
		</div>

		<form action="<%=ORSView.INSURANCE_LIST_CTL%>" method="POST">
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">

			<div
				class="p-3 bg-light border-bottom d-flex flex-wrap gap-2 align-items-center">
				<input type="text" name="customerName"
					class="form-control form-control-sm" style="max-width: 220px;"
					placeholder="Search by customerName"
					value="<%=ServletUtility.getParameter("customerName", request)%>">
				<input type="text" name="claimStatus"
					class="form-control form-control-sm" style="max-width: 220px;"
					placeholder="Search by Claim Status"
					value="<%=ServletUtility.getParameter("claimStatus", request)%>">
				<button type="submit" name="operation"
					value="<%=BaseCtl.OP_SEARCH%>" class="btn btn-primary btn-sm">
					<i class="bi bi-search me-1"></i>
					<%=ms.get("button.search")%>
				</button>
				<button type="submit" name="operation"
					value="<%=BaseCtl.OP_DELETE%>"
					class="btn btn-danger btn-sm ms-auto">
					<i class="bi bi-trash me-1"></i><%=ms.get("button.delete.selected")%>
				</button>
			</div>

			<%
			if (_err != null && !_err.isEmpty()) {
			%>
			<div
				class="alert alert-danger alert-dismissible fade show py-2 mx-3 mt-3"
				role="alert">
				<i class="bi bi-exclamation-triangle-fill me-2"></i>
				<%=_err%>

				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
			<%
			}
			%>

			<%
			if (_suc != null && !_suc.isEmpty()) {
			%>
			<div
				class="alert alert-success alert-dismissible fade show py-2 mx-3 mt-3"
				role="alert">
				<i class="bi bi-exclamation-triangle-fill me-2"></i>
				<%=_suc%>

				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
			<%
			}
			%>

			<div class="table-responsive">
				<table class="table table-hover align-middle mb-0">
					<thead class="table-dark">
						<tr>
							<th width="40"><input type="checkbox"
								onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)"></th>
							<th><%=ms.get("daily.sr")%></th>
							<th><%=ms.get("daily.cstName")%></th>
							<th><%=ms.get("daily.policyType")%></th>
							<th><%=ms.get("daily.preAmt")%></th>
							<th><%=ms.get("daily.status")%></th>
							<th><%=ms.get("button.edit")%></th>
						</tr>
					</thead>
					<tbody>
						<%
						while (it.hasNext()) {
							InsuranceBean bean = it.next();
						%>
						<tr>
							<td><input type="checkbox" name="ids"
								value="<%=bean.getId()%>"></td>
							<td class="text-muted small"><%=index++%></td>
							<td class="fw-semibold"><%=bean.getCustomer_name()%></td>
							<td><%=bean.getPolicy_type()%></td>
							<td><%=bean.getPremium_amt()%></td>
							<td><%=bean.getClaim_status()%></td>
							<td><a href="InsuranceCtl?id=<%=bean.getId()%>"
								class="btn btn-sm btn-outline-primary"> <i
									class="bi bi-pencil"></i> <%=ms.get("button.edit")%>
							</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>

			<div class="p-3 border-top">
				<%@ include file="ListFooter.jsp"%>
			</div>
		</form>
	</div>
</div>
