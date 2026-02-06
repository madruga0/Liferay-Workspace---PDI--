package mvc.portlet.pdi.portlet.resourceCmd;

public class ResourceCommand  {
    
}



// Liferay code example
/*
@Component(
	property = {
		"javax.portlet.name=com_acme_p8v5_web_internal_portlet_P8V5Portlet",
		"mvc.command.name=/p8v5/download"
	},
	service = MVCResourceCommand.class
)
public class P8V5DownloadMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException {

		try {
			PortletResponseUtil.sendFile(
				resourceRequest, resourceResponse, "p8v5.txt",
				"Hello P8V5!".getBytes(), "text");

			return false;
		}
		catch (IOException ioException) {
			_log.error(ioException, ioException);

			return true;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		P8V5DownloadMVCResourceCommand.class);

}
*/