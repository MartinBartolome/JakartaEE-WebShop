<%@ include file="header.jspf" %> 
	<form action="getactivationcode" method="post">
	<fieldset>
	<legend><fmt:message key="getActivationCode"/>: </legend>
	<table>
		<tbody>
		<tr>
			<th>
				<label for="UName"><fmt:message key="UserName"/>:</label>
			</th>
			<td>
				<input 
					type="text"
					name="UName"
					id="UName"
					size="40"
					maxlength="40"
					placeholder=<fmt:message key="UserName"/>
					pattern=".{6,40}" 
					required="required">
			</td>
		</tr>
		<tr>
			<th>
				<label for="email">
					<fmt:message key="email"/>:
				</label>
			</th>
			<td>
				<input 
					type="email"
					name="email"
					id="email"
					size="10"
					maxlength="10"
					title="6-10 Zeichen"
					placeholder=@
					pattern=".{6,10}" 
					required="required">
			</td>
		</tr>
		<tr>
			<td/><td>
				<input type="submit" value=<fmt:message key="request"/>>
			</td>
		</tr>
	</tbody>
	</table>
	</fieldset>
	</form>
<%@ include file="footer.jspf" %>
