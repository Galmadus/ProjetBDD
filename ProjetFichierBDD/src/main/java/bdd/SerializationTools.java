package bdd;

import java.io.*;
import java.util.TreeSet;

/**
 * Classe qui contient des outils de sérialization
 *
 * @author Jason Mahdjoub
 * @version 1.0
 */
class SerializationTools {
    /**
     * Serialise/binarise l'objet passé en paramètre pour retourner un tableau binaire
     *
     * @param o l'objet à serialiser
     * @return the tableau binaire
     * @throws IOException si un problème d'entrée/sortie se produit
     */
    static byte[] serialize(Serializable o) throws IOException {
        if (o != null) {
            ByteArrayOutputStream tab = new ByteArrayOutputStream();
            ObjectOutputStream obj = new ObjectOutputStream(tab);
            obj.writeObject(o);
            obj.flush();
            return tab.toByteArray();
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Désérialise le tableau binaire donné en paramètre pour retrouver l'objet initial avant sa sérialisation
     *
     * @param data le tableau binaire
     * @return l'objet désérialisé
     * @throws IOException            si un problème d'entrée/sortie se produit
     * @throws ClassNotFoundException si un problème lors de la déserialisation s'est produit
     */
    static Serializable deserialize(byte[] data) throws IOException, ClassNotFoundException {
        if (data != null) {
			ByteArrayInputStream tab = new ByteArrayInputStream(data);
			ObjectInputStream obj = new ObjectInputStream(tab);
			return (Serializable) obj.readObject();

		} else {
            throw new NullPointerException();
        }
    }

    /**
     * Serialise/binarise le tableau d'espaces libres passé en paramètre pour retourner un tableau binaire, mais selon le schéma suivant :
     * Pour chaque interval ;
     * <ul>
     *     <li>écrire en binaire la position de l'interval</li>
     *     <li>écrire en binaire la taille de l'interval</li>
     * </ul>
     * Utilisation pour cela la classe {@link DataOutputStream}
     *
     * @param freeSpaceIntervals le tableau d'espaces libres
     * @return un tableau binaire
     * @throws IOException si un problème d'entrée/sortie se produit
     */
    static byte[] serializeFreeSpaceIntervals(TreeSet<BDD.FreeSpaceInterval> freeSpaceIntervals) throws IOException {
        if (freeSpaceIntervals != null) {
            return null;
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Effectue l'opération inverse de la fonction {@link #serializeFreeSpaceIntervals(TreeSet)}
     *
     * @param data le tableau binaire
     * @return le tableau d'espaces libres
     * @throws IOException si un problème d'entrée/sortie se produit
     */
    static TreeSet<BDD.FreeSpaceInterval> deserializeFreeSpaceIntervals(byte[] data) throws IOException {
        if (data != null) {
            return null;
        } else {
            throw new NullPointerException();
        }
    }
}
