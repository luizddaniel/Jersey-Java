package br.com.estudo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.jboss.logging.Param;

@Path("task")
public class TaskResource {

	private Session session = HibernateSession.getSessionFactory()
			.openSession();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskEntity> find(){
		List<TaskEntity> task = session.createQuery("from TaskEntity").getResultList();
		
		return task;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public TaskEntity findOne(@PathParam("id") Integer id){
		
		return session.find(TaskEntity.class, id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Task create(Task task) {
		session.beginTransaction();

		TaskEntity taskEntity = new TaskEntity(task.getData_inicio(),
				task.getDescripition(), task.getStatus(), task.getData_fim());
		
		session.save(taskEntity);
		session.getTransaction().commit();
		session.getSessionFactory().close();
		
		return task;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public TaskEntity update(@PathParam("id") Integer id, Task task){
		session.beginTransaction();
		
		TaskEntity taskEntity = session.find(TaskEntity.class, id);
		
		taskEntity.setData_inicio(task.getData_inicio());
		taskEntity.setDescripition(task.getDescripition());
		taskEntity.setStatus(task.getStatus());
		taskEntity.setData_fim(task.getData_fim());
		
		session.save(taskEntity);
		session.getTransaction().commit();
		session.getSessionFactory().close();
		
		return taskEntity;
	}
	
	@DELETE
	@Path("{id}")
	public Boolean delete(@PathParam("id") Integer id){
		session.beginTransaction();
		
		TaskEntity taskEntity = session.find(TaskEntity.class, id);
		
		if(taskEntity == null){
			return false;
		}
		
		session.delete(taskEntity);
		session.getTransaction().commit();
		session.getSessionFactory().close();
		
		
		return true;
	}
}
