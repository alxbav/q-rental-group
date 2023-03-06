package ee.qrental.link.application.port.in.query;

import ee.qrental.common.core.api.query.BaseGetQuery;
import ee.qrental.link.application.port.in.request.LinkUpdateRequest;
import ee.qrental.link.application.port.in.response.LinkResponse;

import java.util.List;

public interface GetLinkQuery
        extends BaseGetQuery<LinkUpdateRequest, LinkResponse> {

    List<LinkResponse> getActiveLinks();
}