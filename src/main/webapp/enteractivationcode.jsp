<%@ include file="header.jspf" %> 
	<form action="enteractivationcode" method="post">
	<fieldset>
	<legend><fmt:message key="enteractivationcode"/>: </legend>
	<table>
		<tbody>
		<tr>
			<th>
				<label for="ActivationCode"><fmt:message key="activationCode"/>:</label>
			</th>
			<td>
				<input
						type="text"
						name="ActivationCode"
						id="ActivationCode"
						size="40"
						maxlength="40"
						placeholder=<fmt:message key="activationCodefromEmail"/>
								pattern=".{6,40}"
						required="required">
			</td>
		</tr>
		<tr>
			<th>
				<label for="newPassword"><fmt:message key="newpassword"/>:</label>
			</th>
			<td>
				<input
						type="password"
						name="newPassword"
						id="newPassword"
						size="40"
						maxlength="40"
						required="required">
			</td>
		</tr>
		<tr>
			<th>
				<label for="repeatnewPassword">
					<fmt:message key="newpasswordrepeat"/>:
				</label>
			</th>
			<td>
				<input 
					type="password"
					name="repeatnewPassword"
					id="repeatnewPassword"
					size="10"
					maxlength="10"
					title="6-10 Zeichen"
					pattern=".{6,10}" 
					required="required">
			</td>
		</tr>
		<tr>
			<td/><td>
				<input type="submit" value="OK">
			</td>
		</tr>
	</tbody>
	</table>
	</fieldset>
	</form>
<%@ include file="footer.jspf" %>
