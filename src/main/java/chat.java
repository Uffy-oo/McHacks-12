import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import java.io.IOException;

public class chat {

    public static void main(String[] args) throws IOException {
        // TODO(developer): Replace these variables before running the sample.
        String projectId = "mythic-lead-448919-s4";
        String location = "northamerica-northeast1";
        String modelName = "gemini-1.5-flash-001";
        String textPrompt =
                "I am seeing a doctor soon. What are some questions that I might be asked? Help me prepare and give me advices";

        String output = textInput(projectId, location, modelName, textPrompt);
        System.out.println(output);
    }

    // Passes the provided text input to the Gemini model and returns the text-only response.
    // For the specified textPrompt, the model returns a list of possible store names.
    public static String textInput(
            String projectId, String location, String modelName, String textPrompt) throws IOException {
        // Initialize client that will be used to send requests. This client only needs
        // to be created once, and can be reused for multiple requests.
        try (VertexAI vertexAI = new VertexAI(projectId, location)) {
            GenerativeModel model = new GenerativeModel(modelName, vertexAI);

            GenerateContentResponse response = model.generateContent(textPrompt);
            String output = ResponseHandler.getText(response);
            return output;
        }
    }
}