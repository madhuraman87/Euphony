<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<div class="modal fade" id="feedbackModal" data-backdrop='static'
	tabindex="-1" role="dialog" aria-labelledby="FeedbackModal"
	aria-hidden="true">
	<div class="modal-dialog custom-class">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" id="close_icon"
					aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel" style="text-align: center;color: #317eac;font-size: 30px"></h4>				
			</div>
			<div class="modal-body ">
			 <form id="feedbackForm" class="form-horizontal">
			<fieldset>
						<!-- Text input-->
						<div class="control-group ">
							<div class="controls">
								<div class="col-xs-6 col-md-4 ">
									<label class="required" for="album_id" style="display: inline;"  >Album ID:</label>
								</div>
								<div class="col-xs-12 col-md-8">
									<input id="album_id" name="album_id" class="form-control " type="text" placeholder="Album ID"
										 style="display: inline;" required>
								</div>
							</div>
						</div>
						
						<br><br><br>
						<!-- Text input-->
						<div class="control-group">
							<div class="controls">
								<div class="col-xs-6 col-md-4">						
										<label  class="required" for="artist_id" style="display: inline;">Artist ID:</label>
									</div>
									<div class="col-xs-12 col-md-8">
										 <input id="artist_id" name="artist_id" type="number" class="form-control" 
									placeholder="Artist Id" style="display: inline;" >
								</div>								

							</div>
						</div>
						<br><br><br>
						<!-- Text input-->
						<div class="control-group" >
							<div class="controls">
								<div class="col-xs-6 col-md-4">						
									<label  class="required" for="genre_id" style="display: inline;">Genre:</label>
								</div>
								<div class="col-xs-12 col-md-8">
									<input id="genre_id" name="genre_id" type="text" class="form-control" placeholder="Genre" style="display: inline;" >
								</div>	
								 
							</div>
						</div>
						<br><br><br>
						<div class="control-group" id="trackdiv">
							<div class="controls">
								<div class="col-xs-6 col-md-4">						
										<label class="required" for="track_id" style="display: inline;">Track ID:</label>
									</div>
									<div class="col-xs-12 col-md-8">
										<input id="track_id" name="track_id" type="text" class="form-control " placeholder="Track ID"
									style="display: inline;" required >
								</div>	
								
							</div>
						</div>
						<br><br><br>	
							<div class="control-group" id="trackdiv">
							<div class="controls">
								<div class="col-xs-6 col-md-4">						
										<label class="required" for="track_id" style="display: inline;">Score:</label>
									</div>
									<div class="col-xs-12 col-md-8">
										<input id="score" name="score" type="text" class="form-control " placeholder="Score"
									style="display: inline;" required >
								</div>	
								
							</div>
						</div>		
						<br><br><br>			
						<div class="control-group">
							<div class="controls">
								<div class="col-xs-6 col-md-4">						
										<label class="required" for="type" style="display: inline;">Feedback</label>
									</div>
									<div class="col-xs-12 col-md-8">
										<input id="feedback" name="feedback" type="number" class="form-control " placeholder="Feedback Score"
									style="display: inline;" required >
									
								</div>	
								
							</div>
						</div>							

					</fieldset>
            <div class="modal-footer">
            	<button type="button" id="close" class="btn btn-default" data-dismiss="modal">Close</button>
            <input id="feedback_save" class="button btn-primary"  type="submit" value="submit"/>
            </div>
        </form>
				
			</div>
			
		</div>
	</div>
</div>

