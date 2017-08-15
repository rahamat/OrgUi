function handleJSON(xhr, status, args) {
	console.log(args.uiOrgData);
}
function clickedResource(resourceId, resourceType) {
	event.stopPropagation();
	clickedResourceType = resourceType;
	clickedResourceCmd([ {
		name : 'resourceType',
		value : resourceType
	}, {
		name : 'resourceId',
		value : resourceId
	} ]);
}
function showSelectedUi() {
	console.log(clickedResourceType)
	if ('branch' == clickedResourceType)
		showBranchUi();
	else if ('zone' == clickedResourceType)
		showZoneUi();
	else if ('location' == clickedResourceType)
		showLocUi();
}

function showLocUi() {
	$('.locModal').slideToggle();
	$('.close').on('click', function() {
		$('.locModal').hide();
	});
}

function showZoneUi() {
	$('.zoneModal').slideToggle();
	$('.close').on('click', function() {
		$('.zoneModal').hide();
	});
}

function showBranchUi() {
	$('.branchModal').slideToggle();
	$('.close').on('click', function() {
		$('.branchModal').hide();
	});
}
