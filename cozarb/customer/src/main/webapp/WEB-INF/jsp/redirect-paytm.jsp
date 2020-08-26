<div style="margin: 100px; text-align: center;">
	<h1>Please do not refresh this page...</h1>

	<form method="post" action="${payTMUrl}" name="f1" id="f1">
	    <input type="hidden" name="MID" value="${mid}"/>
	    <input type="hidden" name="ORDER_ID" value="${orderId}"/>
	    <input type="hidden" name="CUST_ID" value="${customerId}"/>
	    <input type="hidden" name="INDUSTRY_TYPE_ID" value="${industryTypeId}"/>
	    <input type="hidden" name="CHANNEL_ID" value="${channelId}"/>
	    <input type="hidden" name="TXN_AMOUNT" value="${transactionAmount}"/>
	    <input type="hidden" name="WEBSITE" value="${website}"/>
	    <input type="hidden" name="CALLBACK_URL" value="${callbackUrl}"/>
	    <input type="hidden" name="CHECKSUMHASH" value="${paytmChecksum}"/>
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#f1").submit();
		}); 
	</script>
</div>